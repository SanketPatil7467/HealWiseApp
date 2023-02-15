package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BloodCommunity extends AppCompatActivity {
    EditText community_blood_group;
    EditText editTextTextEmailAddress;
    Button join_community;
    DatabaseReference reference;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int stat = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_community);

        join_community = findViewById(R.id.join_community);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        community_blood_group = findViewById(R.id.community_blood_group);

        Intent int1 = getIntent();
        String email_address =int1.getStringExtra(MainDashboard.MSG2);


        join_community.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String blood_group = community_blood_group.getText().toString();
                String mail = editTextTextEmailAddress.getText().toString();
                db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
                reference = db.getReference("BloodGroupCommunity");
                reference.child(email_address).child("Email").setValue(mail);
                reference.child(email_address).child("Blood Group").setValue(blood_group);


                Toast.makeText(BloodCommunity.this, "Added to community "+blood_group, Toast.LENGTH_SHORT).show();
            }
        });



    }
}