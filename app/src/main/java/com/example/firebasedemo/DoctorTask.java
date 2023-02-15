package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class DoctorTask extends AppCompatActivity {
    public static final String MSG = "order";
    private Button doc_task_but1;
    private EditText patient_username;
    private EditText doc_name;
    private EditText weight;

    EditText date_format;
    EditText date_format2;
    int year;
    int month;
    int day;

    int year2;
    int month2;
    int day2;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_task);

        doc_task_but1 = findViewById(R.id.doc_task_but1);
        patient_username = findViewById(R.id.editTextTextPersonName2);
        doc_name = findViewById(R.id.editTextTextPersonName);
        weight = findViewById(R.id.editTextNumber);
        date_format = findViewById(R.id.dateFormat);
        date_format2 = findViewById(R.id.editTextDate2);

        Intent intent = getIntent();
        String doctor_name =intent.getStringExtra(DoctorLogin.MSG);

        doc_name.setText(doctor_name);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        Calendar calendar2 = Calendar.getInstance();
        year2 = calendar2.get(Calendar.YEAR);
        month2 = calendar2.get(Calendar.MONTH);
        day2 = calendar2.get(Calendar.DAY_OF_MONTH);

        date_format.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(DoctorTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
//                        date_format.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                        month = month+1;
                        if (month == 1){
                            String date = dayOfMonth+" Jan "+ year;
                            date_format.setText(date);

                        } else if (month == 2) {
                            String date = dayOfMonth+" Feb "+ year;
                            date_format.setText(date);


                        } else if (month == 3) {
                            String date = dayOfMonth+" Mar "+ year;
                            date_format.setText(date);


                        }else if (month == 4) {
                            String date = dayOfMonth+" Apr "+ year;

                            date_format.setText(date);

                        }else if (month == 5) {
                            String date = dayOfMonth+" May "+ year;

                            date_format.setText(date);

                        }else if (month == 6) {
                            String date = dayOfMonth+" Jun "+ year;

                            date_format.setText(date);

                        }else if (month == 7) {
                            String date = dayOfMonth+" Jul "+ year;

                            date_format.setText(date);

                        }else if (month == 8) {
                            String date = dayOfMonth+" Aug "+ year;

                            date_format.setText(date);

                        }else if (month == 9) {
                            String date = dayOfMonth+" Sep "+ year;

                            date_format.setText(date);

                        }else if (month == 10) {
                            String date = dayOfMonth+" Oct "+ year;

                            date_format.setText(date);

                        }else if (month == 11) {
                            String date = dayOfMonth+" Nov "+ year;

                            date_format.setText(date);

                        }else if (month == 12) {
                            String date = dayOfMonth+" Dec "+ year;

                            date_format.setText(date);

                        }
                    }

                },year,month,day);
                datePickerDialog.show();
            }
        });

        date_format2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(DoctorTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                        month = month+1;
                        if (month == 1){
                            String date = dayOfMonth+" Jan "+ year;
                            date_format2.setText(date);

                        } else if (month == 2) {
                            String date = dayOfMonth+" Feb "+ year;
                            date_format2.setText(date);


                        } else if (month == 3) {
                            String date = dayOfMonth+" Mar "+ year;
                            date_format2.setText(date);


                        }else if (month == 4) {
                            String date = dayOfMonth+" Apr "+ year;

                            date_format2.setText(date);

                        }else if (month == 5) {
                            String date = dayOfMonth+" May "+ year;

                            date_format2.setText(date);

                        }else if (month == 6) {
                            String date = dayOfMonth+" Jun "+ year;

                            date_format2.setText(date);

                        }else if (month == 7) {
                            String date = dayOfMonth+" Jul "+ year;

                            date_format2.setText(date);

                        }else if (month == 8) {
                            String date = dayOfMonth+" Aug "+ year;

                            date_format2.setText(date);

                        }else if (month == 9) {
                            String date = dayOfMonth+" Sep "+ year;

                            date_format2.setText(date);

                        }else if (month == 10) {
                            String date = dayOfMonth+" Oct "+ year;

                            date_format2.setText(date);

                        }else if (month == 11) {
                            String date = dayOfMonth+" Nov "+ year;

                            date_format2.setText(date);

                        }else if (month == 12) {
                            String date = dayOfMonth+" Dec "+ year;

                            date_format2.setText(date);

                        }

                    }

                },year2,month2,day2);
                datePickerDialog.show();
            }
        });

//        doc_task_but1 = findViewById(R.id.doc_task_but1);
//        patient_username = findViewById(R.id.editTextTextPersonName2);
//        doc_name = findViewById(R.id.editTextTextPersonName);
//        weight = findViewById(R.id.editTextNumber);
//        date_format = findViewById(R.id.dateFormat);
//        date_format2 = findViewById(R.id.editTextDate2);

        doc_task_but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String patient_usernameVar = patient_username.getText().toString();
                String doc_nameVar = doc_name.getText().toString();
                String date_formatVar = date_format.getText().toString();
                String date_format2Var = date_format2.getText().toString();
                String weightVar = weight.getText().toString();
                String uniqueKey = patient_usernameVar+"%%%%"+date_formatVar;


                db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
                reference = db.getReference("Patients");
                reference.child(uniqueKey).child("Appointment Date").setValue(date_formatVar);
                reference.child(uniqueKey).child("Upto date").setValue(date_format2Var);
                reference.child(uniqueKey).child("Username").setValue(patient_usernameVar);
                reference.child(uniqueKey).child("Weight").setValue(weightVar);

                reference.child(uniqueKey).child("Doctor").setValue(doc_nameVar).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(DoctorTask.this, "Data saved..", Toast.LENGTH_SHORT).show();
                    }

                });
                Intent intent2 = new Intent(DoctorTask.this,DoctorTask2.class);
                intent2.putExtra(MSG,uniqueKey);
                startActivity(intent2);
                finish();
            }
        });
    }
}