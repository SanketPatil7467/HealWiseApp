package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorActivity extends AppCompatActivity {
    public static final String MSG = "order";

    private Button add_prescription;
    private Button upload_test_report;
    private Button patient_record;
    private Button search_identity;
    private Button blood_help;
    private Button logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        add_prescription = findViewById(R.id.button2);
        upload_test_report = findViewById(R.id.button10);
        patient_record = findViewById(R.id.button11);
        search_identity = findViewById(R.id.button16);
        blood_help = findViewById(R.id.button17);
        logout = findViewById(R.id.button18);


        Intent intent = getIntent();
        String doctor_name =intent.getStringExtra(DoctorLogin.MSG);


        add_prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorActivity.this, DoctorTask.class);
                intent.putExtra(MSG,doctor_name);
                startActivity(intent);

            }
        });

        upload_test_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorActivity.this, UploadReport.class));
;

            }
        });

        patient_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorActivity.this, ShowRecords2.class));

            }
        });

        search_identity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorActivity.this, IdentifyVictim.class));

            }
        });

        blood_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorActivity.this, SendMail.class));

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorActivity.this, DoctorLogin.class));
                finish();
            }
        });


    }
}