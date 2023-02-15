package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SendMail extends AppCompatActivity {
    Button button_send_mail;
    EditText enter_blood_group;
    EditText subject_area;
    EditText message_area;
    DatabaseReference reference;
    FirebaseDatabase db;
    ArrayList<String> mailList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        message_area = findViewById(R.id.message_area);
        subject_area = findViewById(R.id.subject_area);
        button_send_mail = findViewById(R.id.button_send_mail);
        enter_blood_group = findViewById(R.id.enter_blood_group);

        button_send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject_txt = subject_area.getText().toString();
                String message_txt = message_area.getText().toString();
                String blood_group_txt = enter_blood_group.getText().toString();

                db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
                reference = db.getReference("BloodGroupCommunity");

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                            String key =  dataSnapshot.child("Email").getValue().toString();
                            String bld = dataSnapshot.child("Blood Group").getValue().toString();
                            mailList.add(key);
                            System.out.println(mailList);


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                String[] arr = mailList.toArray(new String[mailList.size()]);

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, arr);
                intent.putExtra(Intent.EXTRA_SUBJECT,subject_txt);
                intent.putExtra(Intent.EXTRA_TEXT, message_txt);


                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SendMail.this, "No supported app to send mail", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}