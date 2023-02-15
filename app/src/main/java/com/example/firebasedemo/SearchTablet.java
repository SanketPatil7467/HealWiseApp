package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Objects;

public class SearchTablet extends AppCompatActivity {
    int t1;
    int t2;
    EditText tab1;
    EditText tab2;
    Button search;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tablet);

        tab1 = findViewById(R.id.editTextTextPersonName4);
        tab2 = findViewById(R.id.editTextTextPersonName5);
        search = findViewById(R.id.button9);
        result = findViewById(R.id.textView22);

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("Dolo 650",1);
        map.put("Medomol 650",1);
        map.put("Dolopolo 650",1);
        map.put("Calpol 650",1);
        map.put("Fepanil 650",1);
        map.put("Paracip 650",1);
        map.put("Macfast 650",1);
        map.put("Febrinil 650",1);
        map.put("Pacimol 650",1);
        map.put("Parasafe 650",1);
        map.put("Dolopar 650",1);
        map.put("PUC 650",1);
        map.put("Paragreat 650mg",1);
        map.put("Algina 650",1);
        map.put("XTPara 650",1);
        map.put("P 650",1);

        map.put("tablet21", 2);
        map.put("tablet22", 2);
        map.put("tablet23", 2);
        map.put("tablet24", 2);
        map.put("tablet25", 2);
        map.put("tablet26", 2);
        map.put("tablet27", 2);
        map.put("tablet28", 2);
        map.put("tablet29", 2);

        map.put("tablet31", 3);
        map.put("tablet32", 3);
        map.put("tablet33", 3);
        map.put("tablet34", 3);
        map.put("tablet35", 3);
        map.put("tablet36", 3);
        map.put("tablet37", 3);
        map.put("tablet38", 3);
        map.put("tablet39", 3);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tab1_txt = tab1.getText().toString();
                String tab2_txt = tab2.getText().toString();

                if (tab1_txt.isEmpty() || tab2_txt.isEmpty()){
                    Toast.makeText(SearchTablet.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    t1 = map.get(tab1_txt);
                    t2 = map.get(tab2_txt);

                    if (t1 == t2){
                        result.setText("Matching Tablets");
                    } else if (Objects.isNull(map.get(tab1_txt)) || Objects.isNull(map.get(tab2_txt))) {
                        result.setText("Not Matching tablets");
                        Toast.makeText(SearchTablet.this, "We only have limited amount of dataset", Toast.LENGTH_SHORT).show();

                    } else {
                        result.setText("Not Matching tablets");
                    }

                }



            }
        });
    }
}