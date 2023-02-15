package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShowRecords2 extends AppCompatActivity {
    public static final String MSG = "order";
    private EditText user_name;
    private Button search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_records2);

        user_name = findViewById(R.id.editTextTextPersonName7);
        search = findViewById(R.id.button19);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = user_name.getText().toString();
                Intent intent = new Intent(ShowRecords2.this,ShowRecords.class);
                intent.putExtra(MSG,name);
                startActivity(intent);
            }
        });
    }
}