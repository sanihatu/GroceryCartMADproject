package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groceryycartt.Adapters.ItemAdapter;
import com.example.groceryycartt.Models.ItemModel;

import java.util.ArrayList;

public class DiaryActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    TextView order;
    ImageButton back;

    ArrayList<ItemModel> list;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        Intent intent=getIntent();
        order=findViewById(R.id.orders);
        display();
        String ShoopName=intent.getStringExtra("shopname");
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("shopname",ShoopName);
        editor.apply();
        String shop=sharedPreferences.getString("shopname","").toString();
//        Toast.makeText(getApplicationContext(), "Welcome "+shop, Toast.LENGTH_SHORT).show();
        back=findViewById(R.id.backdiary);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
//                intent.putExtra("shopname",shop);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiaryActivity.this, OrdersActivity.class));
            }
        });
    }


        private void display() {
            recyclerView=findViewById(R.id.recylerview);
//            recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(this,1));
            list=new ArrayList<>();
            list.add(new ItemModel(R.drawable.milk,"Amul Taaza Milk (500ml)","24","Freshly sourced, creamy milk available for purchase, perfect for a nutritious and delicious addition to your daily routine."));
            list.add(new ItemModel(R.drawable.cheese,"Amul Cheese Spread(200ml)","97","Made with Yummy milk and meticulously crafted for the ultimate flavor experience."));
            list.add(new ItemModel(R.drawable.yogurt,"Milky Mist Yogurt(100ml)","31"," Fruit Yogurt - Blueberry,Great Source of Probiotics ,Light and Healthy Fruit Yogurt"));
            list.add(new ItemModel(R.drawable.butter,"Milky Mist Butter(500mg)","277","Experience the rich, velvety goodness of our premium butter, guaranteed to elevate your culinary creations to new heights."));
            list.add(new ItemModel(R.drawable.curd,"Milky Mist Curd/Dahi(400ml)","38","Discover the creamy delight of our handcrafted curd, a perfect balance of tanginess and smoothness."));

            itemAdapter=new ItemAdapter(list,this);
            recyclerView.setAdapter(itemAdapter);
    }
}