package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class IdentifyVictim extends AppCompatActivity {
    StringBuilder str = new StringBuilder("Matched Persons: ");
    private EditText blood_group_entry;
    private EditText weight_entry;
    private EditText height_entry;
    private TextView result_person;
    private Button search_person;

    ArrayList<String> blood_group = new ArrayList<String>();
    ArrayList<Integer> body_mass = new ArrayList<Integer>();
    ArrayList<Integer> height = new ArrayList<Integer>();
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<Integer> result = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_victim);

        blood_group_entry = findViewById(R.id.blood_group);
        weight_entry = findViewById(R.id.weight);
        height_entry = findViewById(R.id.height);
        result_person = findViewById(R.id.result_person);
        search_person = findViewById(R.id.search_person);

        blood_group.add(0, "O+");
        blood_group.add(1, "AB-");
        blood_group.add(2, "B+");
        blood_group.add(3, "A-");
        blood_group.add(4, "O+");
        blood_group.add(5, "AB+");
        blood_group.add(6, "B-");
        blood_group.add(7, "A+");
        blood_group.add(8, "O-");
        blood_group.add(9, "AB+");
        blood_group.add(10, "B+");

        blood_group.add(11, "A-");
        blood_group.add(12, "O+");
        blood_group.add(13, "AB-");
        blood_group.add(14, "B-");
        blood_group.add(15, "A+");
        blood_group.add(16, "O-");
        blood_group.add(17, "AB+");
        blood_group.add(18, "B+");
        blood_group.add(19, "A-");
        blood_group.add(20, "O+");

        blood_group.add(21, "AB-");
        blood_group.add(22, "B-");
        blood_group.add(23, "A+");
        blood_group.add(24, "O-");
        blood_group.add(25, "AB+");
        blood_group.add(26, "B+");
        blood_group.add(27, "A-");
        blood_group.add(28, "O+");
        blood_group.add(29, "AB-");
        blood_group.add(30, "B-");

        blood_group.add(31, "A+");
        blood_group.add(32, "O-");
        blood_group.add(33, "AB+");
        blood_group.add(34, "B+");
        blood_group.add(35, "A-");
        blood_group.add(36, "O+");
        blood_group.add(37, "AB-");
        blood_group.add(38, "B-");
        blood_group.add(39, "A+");
        blood_group.add(40, "O-");

        blood_group.add(41, "AB+");
        blood_group.add(42, "B+");
        blood_group.add(43, "A-");
        blood_group.add(44, "O+");
        blood_group.add(45, "AB-");
        blood_group.add(46, "B-");
        blood_group.add(47, "A+");
        blood_group.add(48, "O-");
        blood_group.add(49, "AB+");
        blood_group.add(50, "B+");

        blood_group.add(51, "A-");
        blood_group.add(52, "O+");
        blood_group.add(53, "AB-");
        blood_group.add(54, "B-");
        blood_group.add(55, "A+");
        blood_group.add(56, "O-");
        blood_group.add(57, "AB+");
        blood_group.add(58, "B+");
        blood_group.add(59, "A-");
        blood_group.add(60, "O+");

        blood_group.add(61, "AB-");
        blood_group.add(62, "B-");
        blood_group.add(63, "A+");
        blood_group.add(64, "O-");
        blood_group.add(65, "AB+");
        blood_group.add(66, "B+");
        blood_group.add(67, "A-");
        blood_group.add(68, "O+");
        blood_group.add(69, "AB-");
        blood_group.add(70, "B-");

        blood_group.add(71, "A+");
        blood_group.add(72, "O-");
        blood_group.add(73, "AB+");
        blood_group.add(74, "B+");
        blood_group.add(75, "A-");
        blood_group.add(76, "O+");
        blood_group.add(77, "AB-");
        blood_group.add(78, "B-");
        blood_group.add(79, "A+");
        blood_group.add(80, "O-");

        blood_group.add(81, "AB+");
        blood_group.add(82, "B+");
        blood_group.add(83, "A-");
        blood_group.add(84, "O+");
        blood_group.add(85, "AB-");
        blood_group.add(86, "B-");
        blood_group.add(87, "A+");
        blood_group.add(88, "O-");
        blood_group.add(89, "AB+");
        blood_group.add(90, "B+");

        blood_group.add(91, "A-");
        blood_group.add(92, "O+");
        blood_group.add(93, "AB-");
        blood_group.add(94, "B-");
        blood_group.add(95, "A+");
        blood_group.add(96, "O-");
        blood_group.add(97, "AB+");
        blood_group.add(98, "B+");
        blood_group.add(99, "A-");


        body_mass.add(0, 70);
        body_mass.add(1, 60);
        body_mass.add(2, 75);
        body_mass.add(3, 65);
        body_mass.add(4, 80);
        body_mass.add(5, 55);
        body_mass.add(6, 70);
        body_mass.add(7, 60);
        body_mass.add(8, 75);
        body_mass.add(9, 65);
        body_mass.add(10, 80);
        body_mass.add(11, 55);
        body_mass.add(12, 70);
        body_mass.add(13, 60);
        body_mass.add(14, 75);
        body_mass.add(15, 65);
        body_mass.add(16, 80);
        body_mass.add(17, 55);
        body_mass.add(18, 70);
        body_mass.add(19, 60);
        body_mass.add(20, 75);
        body_mass.add(21, 65);
        body_mass.add(22, 80);
        body_mass.add(23, 55);
        body_mass.add(24, 70);
        body_mass.add(25, 60);
        body_mass.add(26, 75);
        body_mass.add(27, 65);
        body_mass.add(28, 80);
        body_mass.add(29, 55);
        body_mass.add(30, 70);
        body_mass.add(31, 60);
        body_mass.add(32, 75);
        body_mass.add(33, 65);
        body_mass.add(34, 80);
        body_mass.add(35, 55);
        body_mass.add(36, 70);
        body_mass.add(37, 60);
        body_mass.add(38, 75);
        body_mass.add(39, 65);
        body_mass.add(40, 80);
        body_mass.add(41, 55);
        body_mass.add(42, 70);
        body_mass.add(43, 60);
        body_mass.add(44, 75);
        body_mass.add(45, 65);
        body_mass.add(46, 80);
        body_mass.add(47, 55);
        body_mass.add(48, 70);
        body_mass.add(49, 60);
        body_mass.add(50, 75);
        body_mass.add(51, 65);
        body_mass.add(52, 80);
        body_mass.add(53, 55);
        body_mass.add(54, 70);
        body_mass.add(55, 60);
        body_mass.add(56, 75);
        body_mass.add(57, 65);
        body_mass.add(58, 80);
        body_mass.add(59, 46);
        body_mass.add(60, 54);
        body_mass.add(61, 65);
        body_mass.add(62, 67);
        body_mass.add(63, 51);
        body_mass.add(64, 53);
        body_mass.add(65, 59);
        body_mass.add(66, 58);
        body_mass.add(67, 57);
        body_mass.add(68, 63);
        body_mass.add(69, 64);
        body_mass.add(70, 66);
        body_mass.add(71, 67);
        body_mass.add(72, 73);
        body_mass.add(73, 72);
        body_mass.add(74, 68);
        body_mass.add(75, 48);
        body_mass.add(76, 47);
        body_mass.add(77, 49);
        body_mass.add(78, 46);
        body_mass.add(79, 84);
        body_mass.add(80, 83);
        body_mass.add(81, 74);
        body_mass.add(82, 76);
        body_mass.add(83, 77);
        body_mass.add(84, 78);
        body_mass.add(85, 69);
        body_mass.add(86, 43);
        body_mass.add(87, 44);
        body_mass.add(88, 57);
        body_mass.add(89, 59);
        body_mass.add(90, 64);
        body_mass.add(91, 66);
        body_mass.add(92, 77);
        body_mass.add(93, 88);
        body_mass.add(94, 89);
        body_mass.add(95, 82);
        body_mass.add(96, 81);
        body_mass.add(97, 74);
        body_mass.add(98, 76);
        body_mass.add(99, 61);

        height.add(0, 154);
        height.add(1, 152);
        height.add(2, 153);
        height.add(3, 160);
        height.add(4, 159);
        height.add(5, 163);
        height.add(6, 164);
        height.add(7, 177);
        height.add(8, 169);
        height.add(9, 163);
        height.add(10, 180);
        height.add(11, 155);
        height.add(12, 170);
        height.add(13, 160);
        height.add(14, 175);
        height.add(15, 165);
        height.add(16, 180);
        height.add(17, 155);
        height.add(18, 170);
        height.add(19, 160);
        height.add(20, 175);
        height.add(21, 165);
        height.add(22, 166);
        height.add(23, 155);
        height.add(24, 170);
        height.add(25, 160);
        height.add(26, 175);
        height.add(27, 165);
        height.add(28, 180);
        height.add(29, 155);
        height.add(30, 170);
        height.add(31, 160);
        height.add(32, 175);
        height.add(33, 165);
        height.add(34, 180);
        height.add(35, 155);
        height.add(36, 170);
        height.add(37, 160);
        height.add(38, 175);
        height.add(39, 165);
        height.add(40, 164);
        height.add(41, 155);
        height.add(42, 170);
        height.add(43, 160);
        height.add(44, 175);
        height.add(45, 165);
        height.add(46, 163);
        height.add(47, 155);
        height.add(48, 170);
        height.add(49, 160);
        height.add(50, 175);
        height.add(51, 165);
        height.add(52, 180);
        height.add(53, 155);
        height.add(54, 170);
        height.add(55, 169);
        height.add(56, 175);
        height.add(57, 165);
        height.add(58, 180);
        height.add(59, 146);
        height.add(60, 154);
        height.add(61, 165);
        height.add(62, 167);
        height.add(63, 151);
        height.add(64, 153);
        height.add(65, 159);
        height.add(66, 158);
        height.add(67, 157);
        height.add(68, 163);
        height.add(69, 164);
        height.add(70, 166);
        height.add(71, 167);
        height.add(72, 173);
        height.add(73, 172);
        height.add(74, 168);
        height.add(75, 148);
        height.add(76, 147);
        height.add(77, 149);
        height.add(78, 146);
        height.add(79, 184);
        height.add(80, 183);
        height.add(81, 174);
        height.add(82, 176);
        height.add(83, 177);
        height.add(84, 178);
        height.add(85, 169);
        height.add(86, 143);
        height.add(87, 144);
        height.add(88, 157);
        height.add(89, 159);
        height.add(90, 164);
        height.add(91, 166);
        height.add(92, 177);
        height.add(93, 188);
        height.add(94, 189);
        height.add(95, 182);
        height.add(96, 181);
        height.add(97, 174);
        height.add(98, 176);
        height.add(99, 161);

        name.add(0, "Person1");
        name.add(1, "Person2");
        name.add(2, "Person3");
        name.add(3, "Person4");
        name.add(4, "Person5");
        name.add(5, "Person6");
        name.add(6, "Person7");
        name.add(7, "Person8");
        name.add(8, "Person9");
        name.add(9, "Person10");
        name.add(10, "Person11");
        name.add(11, "Person12");
        name.add(12, "Person13");
        name.add(13, "Person14");
        name.add(14, "Person15");
        name.add(15, "Person16");
        name.add(16, "Person17");
        name.add(17, "Person18");
        name.add(18, "Person19");
        name.add(19, "Person20");
        name.add(20, "Person21");
        name.add(21, "Person22");
        name.add(22, "Person23");
        name.add(23, "Person24");
        name.add(24, "Person25");
        name.add(25, "Person26");
        name.add(26, "Person27");
        name.add(27, "Person28");
        name.add(28, "Person29");
        name.add(29, "Person30");
        name.add(30, "Person31");
        name.add(31, "Person32");
        name.add(32, "Person33");
        name.add(33, "Person34");
        name.add(34, "Person35");
        name.add(35, "Person36");
        name.add(36, "Person37");
        name.add(37, "Person38");
        name.add(38, "Person39");
        name.add(39, "Person40");
        name.add(40, "Person41");
        name.add(41, "Person42");
        name.add(42, "Person43");
        name.add(43, "Person44");
        name.add(44, "Person45");
        name.add(45, "Person46");
        name.add(46, "Person47");
        name.add(47, "Person48");
        name.add(48, "Person49");
        name.add(49, "Person50");
        name.add(50, "Person51");
        name.add(51, "Person52");
        name.add(52, "Person53");
        name.add(53, "Person54");
        name.add(54, "Person55");
        name.add(55, "Person56");
        name.add(56, "Person57");
        name.add(57, "Person58");
        name.add(58, "Person59");
        name.add(59, "Person60");
        name.add(60, "Person61");
        name.add(61, "Person62");
        name.add(62, "Person63");
        name.add(63, "Person64");
        name.add(64, "Person65");
        name.add(65, "Person66");
        name.add(66, "Person67");
        name.add(67, "Person68");
        name.add(68, "Person69");
        name.add(69, "Person70");
        name.add(70, "Person71");
        name.add(71, "Person72");
        name.add(72, "Person73");
        name.add(73, "Person74");
        name.add(74, "Person75");
        name.add(75, "Person76");
        name.add(76, "Person77");
        name.add(77, "Person78");
        name.add(78, "Person79");
        name.add(79, "Person80");
        name.add(80, "Person81");
        name.add(81, "Person82");
        name.add(82, "Person83");
        name.add(83, "Person84");
        name.add(84, "Person85");
        name.add(85, "Person86");
        name.add(86, "Person87");
        name.add(87, "Person88");
        name.add(88, "Person89");
        name.add(89, "Person90");
        name.add(90, "Person91");
        name.add(91, "Person92");
        name.add(92, "Person93");
        name.add(93, "Person94");
        name.add(94, "Person95");
        name.add(95, "Person96");
        name.add(96, "Person97");
        name.add(97, "Person98");
        name.add(98, "Person99");
        name.add(99, "Person100");

        search_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bloodgroup = blood_group_entry.getText().toString();
                String w = weight_entry.getText().toString();
                String h = height_entry.getText().toString();
                if (bloodgroup.isEmpty() || w.isEmpty() || h.isEmpty()){
                    Toast.makeText(IdentifyVictim.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();

                }
                else {
                    ArrayList<Integer> list = myFunc(blood_group,body_mass,height,result,bloodgroup,Integer.parseInt(w),Integer.parseInt(h));
                    for (int i = 0; i < list.size(); i++) {
                        str.append(" "+name.get(list.get(i)));

                    }
                    result_person.setText(str);

                }

            }
        });
    }

    private ArrayList<Integer> myFunc(ArrayList<String> blood_group, ArrayList<Integer> body_mass,
                                      ArrayList<Integer> height, ArrayList<Integer> result, String b, int m, int h) {
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        ArrayList<Integer> result3 = new ArrayList<Integer>();
        ArrayList<Integer> final_result = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            if (blood_group.get(i).equals(b)) {
                result.add(i);
            }
        }


        for (int i = 0; i < result.size(); i++) {
            if (height.get(result.get(i)) >= h) {
                result2.add(result.get(i));
            }
        }
        // System.out.println(result2);

        for (int i = 0; i < result2.size(); i++) {
            result3.add((body_mass.get(i) - m) * (body_mass.get(i) - m));
        }
        // System.out.println(result3);

        for (int i = 0; i < result2.size(); i++) {
            int a = Collections.min(result3);
            int z = result3.indexOf(a);
            final_result.add(result2.get(z));
            result3.remove(Integer.valueOf(a));
            result2.remove(Integer.valueOf(result2.get(z)));
        }

        return final_result;

    }
}