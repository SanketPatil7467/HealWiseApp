package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorLogin extends AppCompatActivity {
    public static final String MSG = "order";
    private Button button;
    private EditText doc_email;
    private EditText doc_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        button = findViewById(R.id.doc_login_button1);
        doc_email = findViewById(R.id.login_doctor_email);
        doc_pass = findViewById(R.id.login_doctor_password);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt_email = doc_email.getText().toString();
                String txt_password = doc_pass.getText().toString();
                if (txt_password.equalsIgnoreCase("admin")){
                    Intent intent = new Intent(DoctorLogin.this, DoctorActivity.class);
                    intent.putExtra(MSG,txt_email);

                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(DoctorLogin.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}