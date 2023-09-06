package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {
    TextView shop;
    EditText nameRat;
    Button sumbit;
    RatingBar ratingBar;
    Spinner spinner;
    float rateValue;
    String shooopNAME;
    DBHelper db;
    String temp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
//        shop=findViewById(R.id.shopnamerat);
        nameRat=findViewById(R.id.namerat);
        sumbit=findViewById(R.id.submitrat);
        ratingBar=findViewById(R.id.ratingBar);
//        spinner=findViewById(R.id.spinner2);

//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(RatingActivity.this, android.R.layout.simple_spinner_item,shopnames);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String value=adapterView.getItemAtPosition(i).toString();
//                shooopNAME=value;
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        db=new DBHelper(this);

        String username=nameRat.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String shopname = sharedPreferences.getString("shopname", "").toString();
//        shop.setText(shopname);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rateValue=ratingBar.getRating();
                Toast.makeText(RatingActivity.this, "RATING"+rateValue, Toast.LENGTH_SHORT).show();

            }
        });
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.insertratings(shopname,username,rateValue);
                Toast.makeText(RatingActivity.this, "Thank you for your rating", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RatingActivity.this, Location1Activity.class));
            }
        });

    }
}