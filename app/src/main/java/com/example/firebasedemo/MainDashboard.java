package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainDashboard extends AppCompatActivity {
    public static final String MSG = "order";
    public static final String MSG2 = "order2";
    public static final String MSG3 = "order2";

    private Button ride_mode;
    private Button logout;
    private Button reminder;
    private Button search;
    private Button tests;
    private Button records;

    private Button community;
    private TextView username;
    private TextView doctorName;
    private TextView startDate;
    private TextView uptoDate;
    private TextView status;
    DatabaseReference reference;
    FirebaseDatabase db;
    private TextView textView13;
    private TextView textView15;
    private TextView textView17;
    boolean var = false;
    Date date1;
    Date date2;
    Date currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        username = findViewById(R.id.textView11);
        status = findViewById(R.id.textView12);
        doctorName = findViewById(R.id.textView14);
        startDate = findViewById(R.id.textView16);
        uptoDate = findViewById(R.id.textView18);
        textView13 = findViewById(R.id.textView13);
        textView15 = findViewById(R.id.textView15);
        textView17 = findViewById(R.id.textView17);
        logout = findViewById(R.id.button8);
        reminder = findViewById(R.id.button12);
        search = findViewById(R.id.button13);
        records = findViewById(R.id.button14);
        tests = findViewById(R.id.button15);
        community = findViewById(R.id.community);
        ride_mode = findViewById(R.id.ride_mode);

        Intent int1 = getIntent();
        String unique_key2 =int1.getStringExtra(LoginActivity.MSG);
        String[] arr = unique_key2.split("@");
        String unique_key = arr[0];

        ride_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainDashboard.this, TurnOnRideMode.class));
            }
        });

        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDashboard.this, QuestionPage.class);
                intent.putExtra(MSG3,unique_key);
                startActivity(intent);
            }
        });

        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDashboard.this, BloodCommunity.class);
                intent.putExtra(MSG2,unique_key);
                startActivity(intent);

            }
        });

        tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDashboard.this,Reports.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDashboard.this,SearchTablet.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainDashboard.this, "Logged out successfully...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainDashboard.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainDashboard.this, ShowRecords.class);
                intent.putExtra(MSG,unique_key);
                startActivity(intent);

            }
        });

        db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
//        reference = db.getReference("Patients").child(unique_key);
        reference = db.getReference("Patients");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String key = dataSnapshot.child("Username").getValue().toString();
//                    System.out.println(unique_key);
//                    System.out.println(key);


                    if (key.startsWith(unique_key)){
                        Date c = Calendar.getInstance().getTime();
                        System.out.println("Current time => " + c);

                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        String formattedDate = df.format(c);
                        String unformatted_date1 = dateComparison(dataSnapshot.child("Appointment Date").getValue().toString());
                        String unformatted_date2 = dateComparison(dataSnapshot.child("Upto date").getValue().toString());
                        try {
                            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(unformatted_date1);
                            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(unformatted_date2);
                            currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        if ((currentDate.before(date2) && currentDate.after(date1)) || currentDate.equals(date1) || currentDate.equals(date2) ){
                            String uName = dataSnapshot.child("Username").getValue().toString();
                            String docName = dataSnapshot.child("Doctor").getValue().toString();
                            String startDt = dataSnapshot.child("Appointment Date").getValue().toString();
                            String upDt = dataSnapshot.child("Upto date").getValue().toString();

                            username.setText(uName);
                            doctorName.setText(docName);
                            startDate.setText(startDt);
                            uptoDate.setText(upDt);
                            textView13.setText("By Doctor");
                            textView15.setText("Start Date");
                            textView17.setText("Upto");
                            status.setText("You are under Treatment");
                        }

                    }
                    else {
                        username.setText(unique_key);
                        doctorName.setText("");
                        startDate.setText("");
                        uptoDate.setText("");
                        status.setText("You are Fine..!");
                        textView13.setText("");
                        textView15.setText("");
                        textView17.setText("");


                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainDashboard.this, "Database connection failed..", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public static String dateComparison(String sampleDate){
        String dateArr[] = sampleDate.split(" ");
        String dateNum = dateArr[0];
        String year = dateArr[2];
        int month=0;
        if (dateArr[1].equals("Jan")){
            month = 1;
        }
        else if (dateArr[1].equals("Feb")) {
            System.out.println("I am true");
            month = 2;
        }
        else if (dateArr[1].equals("Mar")) {
            month = 3;
        }
        else if (dateArr[1].equals("Apr")) {
            month = 4;
        }
        else if (dateArr[1].equals("May")) {
            month = 5;
        }
        else if (dateArr[1].equals("Jun")) {
            month = 6;
        }
        else if (dateArr[1].equals("Jul")) {
            month = 7;
        }
        else if (dateArr[1].equals("Aug")) {
            month = 8;
        }
        else if (dateArr[1].equals("Sep")) {
            month =9;
        }
        else if (dateArr[1].equals("Oct")) {
            month = 10;
        }
        else if (dateArr[1].equals("Nov")) {
            month = 11;
        }
        else if (dateArr[1].equals("Dec")) {
            month = 12;
        }
        String str_month = String.valueOf(month);
        String finalDate = year+"-"+str_month+"-"+dateNum;

        return finalDate;
    }
}