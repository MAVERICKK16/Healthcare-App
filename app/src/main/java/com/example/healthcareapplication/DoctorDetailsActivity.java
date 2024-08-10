package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr.Sandip Mallick", "Hospital Address : Kolkata", "Exp :20yrs ", "Mobile No :9876097430 ", "700"},
                    {"Doctor Name : Dr.Abhijit Taraphder", "Hospital Address : Berhampore", "Exp :26yrs ", "Mobile No :9576997130 ", "700"},
                    {"Doctor Name : Dr.Abhik Ghosh", "Hospital Address : Kandi", "Exp :9yrs ", "Mobile No :9734902300 ", "500"},
                    {"Doctor Name : Dr.Amarnath Ray", "Hospital Address : Rampurhat", "Exp :33yrs ", "Mobile No :90127858309 ", "700"},
                    {"Doctor Name : Dr.Bikash Sen", "Hospital Address : Kolkata", "Exp :8yrs ", "Mobile No :9183728293 ", "400"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dr.Debmalya Gangopadhya", "Hospital Address : Kolkata", "Exp :26yrs ", "Mobile No :9876556630 ", "700"},
                    {"Doctor Name : Dr.Pavitra Sen", "Hospital Address : Berhampore", "Exp :20yrs ", "Mobile No :9876097430 ", "700"},
                    {"Doctor Name : Dr.Amit Ghosh", "Hospital Address : Kandi", "Exp :5yrs ", "Mobile No :8798765467 ", "500"},
                    {"Doctor Name : Dr.Amitava Ray", "Hospital Address : Rampurhat", "Exp :13yrs ", "Mobile No :8976987689 ", "700"},
                    {"Doctor Name : Dr.Archana Sinha", "Hospital Address : Kolkata", "Exp :9yrs ", "Mobile No :9876097430 ", "400"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr.Sandip Sarkar", "Hospital Address : Kolkata", "Exp :10yrs ", "Mobile No :9876097430 ", "700"},
                    {"Doctor Name : Dr.Abhijit Basak", "Hospital Address : Berhampore", "Exp :7yrs ", "Mobile No :9876097430 ", "700"},
                    {"Doctor Name : Dr.Arnab Ghosh", "Hospital Address : Kandi", "Exp :8yrs ", "Mobile No :9876097430 ", "500"},
                    {"Doctor Name : Dr.Amarnath Sen", "Hospital Address : Rampurhat", "Exp :13yrs ", "Mobile No :9876097430 ", "700"},
                    {"Doctor Name : Dr.Bimal Ghosh", "Hospital Address : Kolkata", "Exp :7yrs ", "Mobile No :8976324523 ", "400"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr.Aritra Saha", "Hospital Address : Kolkata", "Exp :10yrs ", "Mobile No :9078346712 ", "700"},
                    {"Doctor Name : Dr.Joydeb Sinha", "Hospital Address : Berhampore", "Exp :16yrs ", "Mobile No :9889346578 ", "700"},
                    {"Doctor Name : Dr.Avik Pradhan", "Hospital Address : Kandi", "Exp :9yrs ", "Mobile No :9000022334 ", "500"},
                    {"Doctor Name : Dr.Sagnik Roy", "Hospital Address : Rampurhat", "Exp :33yrs ", "Mobile No :9000022222 ", "700"},
                    {"Doctor Name : Dr.Sourav Sen", "Hospital Address : Kolkata", "Exp :8yrs ", "Mobile No :9934563100 ", "400"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr.Sandip Sen", "Hospital Address : Kolkata", "Exp :14yrs ", "Mobile No :9879372352 ", "700"},
                    {"Doctor Name : Dr.Abhijit Ghosh", "Hospital Address : Berhampore", "Exp :12yrs ", "Mobile No :9000234567 ", "700"},
                    {"Doctor Name : Dr.Abhik Das", "Hospital Address : Kandi", "Exp :9yrs ", "Mobile No :9089384789 ", "500"},
                    {"Doctor Name : Dr.Aman Ray", "Hospital Address : Rampurhat", "Exp :11yrs ", "Mobile No :9832409218 ", "700"},
                    {"Doctor Name : Dr.Gautam Sen", "Hospital Address : Kolkata", "Exp :8yrs ", "Mobile No :9820345780 ", "400"},
            };
    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewODTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}