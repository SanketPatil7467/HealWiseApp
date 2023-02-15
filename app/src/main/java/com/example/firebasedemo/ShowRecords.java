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

import java.util.HashMap;

public class ShowRecords extends AppCompatActivity {
    TextView record_doctor_name, record_appointment_date,record_diagnosis_report,record_tablets,record_symptoms;
    DatabaseReference reference;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_records);

        record_doctor_name = findViewById(R.id.record_doctor_name);
        record_appointment_date = findViewById(R.id.record_appointment_date);
        record_diagnosis_report = findViewById(R.id.record_diagnosis_report);
        record_tablets = findViewById(R.id.record_tablets);
        record_symptoms = findViewById(R.id.record_symptoms);


        Intent int1 = getIntent();
        String unique_key =int1.getStringExtra(LoginActivity.MSG);
        String unique_key2 =int1.getStringExtra(ShowRecords2.MSG);



        db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
        reference = db.getReference("Patients");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String key = dataSnapshot.child("Username").getValue().toString();
                    if (key.startsWith(unique_key) || key.startsWith(unique_key2)){

                        HashMap<String, Object> allData = (HashMap<String, Object>) dataSnapshot.child("Prescription").getValue();
                        String[] yourChildArray = allData.keySet().toArray(new String[0]);
                        String tabs = yourChildArray.toString();

                        String docName = dataSnapshot.child("Doctor").getValue().toString();
                        String startDt = dataSnapshot.child("Appointment Date").getValue().toString();
                        String report = dataSnapshot.child("Report").getValue().toString();
//                        String tablets = dataSnapshot.child("Prescription").getValue().toString();
                        String symptoms = dataSnapshot.child("Symptoms").getValue().toString();

                        record_doctor_name.setText(docName);
                        record_appointment_date.setText(startDt);
                        record_diagnosis_report.setText(report);
                        String str = yourChildArray[0];
                        for (int i =1 ;i<yourChildArray.length;i++){
                            str = str.concat(", "+yourChildArray[i]);
                        }
                        record_tablets.setText(str);
                        record_symptoms.setText(symptoms);
                        break;
                    }
                    else {
                        record_doctor_name.setText("");
                        record_appointment_date.setText("");
                        record_diagnosis_report.setText("No Medical record found");
                        record_tablets.setText("");
                        record_symptoms.setText("");

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}