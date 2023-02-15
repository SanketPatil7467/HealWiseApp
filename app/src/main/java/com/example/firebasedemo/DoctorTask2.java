package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorTask2 extends AppCompatActivity {
    public static final String MSG = "order";

    private EditText symptom;
    private EditText report;
    private Button add_new_symptom;
    private Button next;

    FirebaseDatabase db;
    DatabaseReference df;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_task2);

        symptom = findViewById(R.id.editTextTextMultiLine);
        report = findViewById(R.id.editTextTextMultiLine2);
        add_new_symptom = findViewById(R.id.button);
        next = findViewById(R.id.button3);

        Intent int1 = getIntent();
        String unique_key =int1.getStringExtra(DoctorTask.MSG);

        add_new_symptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symptom_text = symptom.getText().toString();
                db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
                df = db.getReference("Patients").child(unique_key);
                df.child("Symptoms").child(String.valueOf(i)).setValue(symptom_text);
                i = i+1;
                symptom.setText("");
                Toast.makeText(DoctorTask2.this, "Symptom is added..", Toast.LENGTH_SHORT).show();

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symptom_text = symptom.getText().toString();
                String report_text = report.getText().toString();
                db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
                df = db.getReference("Patients").child(unique_key);
                df.child("Report").setValue(report_text);
                df.child("Symptoms").child(String.valueOf(i)).setValue(symptom_text);
                Toast.makeText(DoctorTask2.this, "Report is added..", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DoctorTask2.this,DoctorTask3.class);
                intent.putExtra(MSG,unique_key);
                startActivity(intent);
                finish();
            }
        });
    }
}