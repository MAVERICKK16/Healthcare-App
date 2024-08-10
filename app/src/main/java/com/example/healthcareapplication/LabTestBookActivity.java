package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {

    EditText edname,edaddress,edcontact,edpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        edname = findViewById(R.id.editTextLTBFullname);
        edaddress = findViewById(R.id.editTextLTBAdderss);
        edcontact = findViewById(R.id.editTextLTBContact);
        edpincode = findViewById(R.id.editTextLTBPincode);
//        edBooking = findViewById(R.id.buttonLTBBooking);

        Intent intent=getIntent();
//        String[] price = intent.getStringExtra("price".toString().split(java.util.regex.pattern.quote":");
        String data = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,edname.getText().toString(),"",edaddress.getText().toString(), Integer.parseInt(""+edcontact.getText().toString()),""+Integer.parseInt(edpincode.getText().toString()),"",Float.parseFloat(""),"lab");
                db.removeCart(username, "lab");
                Toast.makeText(getApplicationContext(),"Your booking is done successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(LabTestBookActivity.this,HomeActivity.class));
            }
        });
    }
}