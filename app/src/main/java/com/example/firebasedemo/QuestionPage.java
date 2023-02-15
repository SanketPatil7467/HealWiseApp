package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class QuestionPage extends AppCompatActivity {
    private EditText editTextTime8;
    private EditText editTextTime9;
    private EditText editTextTime10;
    private EditText editTextTime11;
    private EditText editTextTime12;
    private Button button7;
    DatabaseReference reference;
    FirebaseDatabase db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);

        Intent int1 = getIntent();
        String unique_key = int1.getStringExtra(MainDashboard.MSG3);

        editTextTime8 = findViewById(R.id.editTextTime8);
        editTextTime9 = findViewById(R.id.editTextTime9);
        editTextTime10 = findViewById(R.id.editTextTime10);
        editTextTime11 = findViewById(R.id.editTextTime11);
        editTextTime12 = findViewById(R.id.editTextTime12);
        button7 = findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextTime8.getText().toString().isEmpty() || editTextTime9.getText().toString().isEmpty() || editTextTime10.getText().toString().isEmpty() || editTextTime11.getText().toString().isEmpty() || editTextTime12.getText().toString().isEmpty()){
                    Toast.makeText(QuestionPage.this, "Enter all the details", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(QuestionPage.this, "Your Reminder has successfully set", Toast.LENGTH_SHORT).show();
            }
        });

        editTextTime8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(editTextTime8);
            }
        });

        editTextTime9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(editTextTime9);
            }
        });

        editTextTime10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(editTextTime10);
            }
        });
        editTextTime11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(editTextTime11);
            }
        });
        editTextTime12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(editTextTime12);
            }
        });

    }

    private void showTimePickerDialog(final EditText editText) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(QuestionPage.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editText.setText(String.format("%02d:%02d", hourOfDay, minute));
                    }
                }, hour, minute, false);
        timePickerDialog.show();

    }
}