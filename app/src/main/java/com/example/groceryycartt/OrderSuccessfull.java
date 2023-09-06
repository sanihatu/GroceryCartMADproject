package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderSuccessfull extends AppCompatActivity {
    Button back;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_successfull);
        back=findViewById(R.id.backBtn);
        db=new DBHelper(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                db.removeCartitems(username);
                Intent intent=new Intent(OrderSuccessfull.this, RatingActivity.class);
                startActivity(intent);
            }
        });
    }
}