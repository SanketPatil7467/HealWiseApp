package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorTask3 extends AppCompatActivity {
    private Spinner before_after;
    private Spinner meal;
    private EditText tablet;
    private EditText tablet_count;
    private EditText minute;
    private Button schedule;
    private Button add_tablet;
    private Button finish;

    FirebaseDatabase db;
    DatabaseReference df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_task3);

        before_after = findViewById(R.id.spinner);
        meal = findViewById(R.id.spinner2);
        tablet = findViewById(R.id.editTextTextPersonName3);
        tablet_count = findViewById(R.id.editTextNumber2);
        minute = findViewById(R.id.editTextNumber3);
        schedule = findViewById(R.id.button4);
        add_tablet = findViewById(R.id.button5);
        finish = findViewById(R.id.button6);

        Intent int1 = getIntent();
        String unique_key =int1.getStringExtra(DoctorTask2.MSG);


        String[] items = new String[]{"Before", "After"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        before_after.setAdapter(adapter);

        String[] items2 = new String[]{"Breakfast", "Launch","Dinner"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        meal.setAdapter(adapter2);

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tablet_name = tablet.getText().toString();
                String tablet_quantity = tablet_count.getText().toString();
                String before_after_selection = before_after.getSelectedItem().toString();
                String meal_selection = meal.getSelectedItem().toString();
                String minute_count = minute.getText().toString();
                String combine = before_after_selection+"%%"+meal_selection+"%%"+minute_count;

                db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
                df = db.getReference("Patients").child(unique_key);
                df.child("Prescription").child(tablet_name).child("Quantity").setValue(tablet_quantity);
                df.child("Prescription").child(tablet_name).child("Dosage").setValue(combine);
                minute.setText("");
                Toast.makeText(DoctorTask3.this, "Tablet schedule added..", Toast.LENGTH_SHORT).show();

            }
        });
        add_tablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tablet_name = tablet.getText().toString();
                String tablet_quantity = tablet_count.getText().toString();
                String before_after_selection = before_after.getSelectedItem().toString();
                String meal_selection = meal.getSelectedItem().toString();
                String minute_count = minute.getText().toString();
                String combine = before_after_selection+"%%"+meal_selection+"%%"+minute_count;
                db = FirebaseDatabase.getInstance("https://fir-demo-5fbe5-default-rtdb.asia-southeast1.firebasedatabase.app/");
                df = db.getReference("Patients").child(unique_key);
                df.child("Prescription").child(tablet_name).child("Quantity").setValue(tablet_quantity);
                df.child("Prescription").child(tablet_name).child("Dosage").setValue(combine);
                minute.setText("");
                tablet.setText("");
                tablet_count.setText("");
                Toast.makeText(DoctorTask3.this, "Tablet added..", Toast.LENGTH_SHORT).show();

            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(DoctorTask3.this,DoctorActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(DoctorTask3.this, "Data saved successfully..", Toast.LENGTH_SHORT).show();
            }
        });

    }
}