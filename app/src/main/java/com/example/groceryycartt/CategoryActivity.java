package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity {
    ImageButton back;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent intent=getIntent();
        back=findViewById(R.id.backcat);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Location1Activity.class));
            }
        });


        String ShoopName= intent.getStringExtra("shopname");
        String ShooopNAME=ShoopName;
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("shopname",ShoopName);
        editor.apply();
//        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String shop=sharedPreferences.getString("shopname","").toString();
//        Toast.makeText(getApplicationContext(), "Welcome "+shop, Toast.LENGTH_SHORT).show();

        CardView DiaryProd=findViewById(R.id.diary);
        DiaryProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, DiaryActivity.class));
                intent.putExtra("shopname",shop);
            }
        });

        CardView FruitsVeg=findViewById(R.id.fruitsVeggi);
        FruitsVeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, FruitsveggiActivity.class));
            }
        });
        CardView GrainsProd=findViewById(R.id.grains);
        GrainsProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, GrainsActivity.class));
            }
        });
        CardView BakeryProd=findViewById(R.id.bakery);
        BakeryProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, BakeryActivity.class));
            }
        });
        CardView PersonalProd=findViewById(R.id.personalcare);
        PersonalProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, PersonalcareActivity.class));
            }
        });
        CardView SpicesProd=findViewById(R.id.species);
        SpicesProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, SpicesActivity.class));
            }
        });
        CardView MeatFish=findViewById(R.id.meatfish);
        MeatFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, MeatfishActivity.class));
            }
        });
        CardView MyOrders=findViewById(R.id.orders);
        MyOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, OrdersActivity.class));
            }
        });
    }
}