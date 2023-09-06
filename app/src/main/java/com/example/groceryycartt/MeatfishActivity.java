package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.groceryycartt.Adapters.ItemAdapter;
import com.example.groceryycartt.Models.ItemModel;

import java.util.ArrayList;

public class MeatfishActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    TextView order;
    ImageButton back;
    ArrayList<ItemModel> list;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meatfish);
        order=findViewById(R.id.orders);
        display();
        back=findViewById(R.id.backmeatfish);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeatfishActivity.this, OrdersActivity.class));
            }
        });
    }
    private void display() {
        recyclerView=findViewById(R.id.recylerview);
//            recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list=new ArrayList<>();
        list.add(new ItemModel(R.drawable.chicken,"Fresho Chicken(500mg)","175","Savor the succulent and tender taste of our farm-raised chicken, the epitome of quality and flavor, ready to elevate your meals"));
        list.add(new ItemModel(R.drawable.mutton,"Fresho Mutton (500mg)","330","Experience the rich and savory indulgence of our premium quality mutton, carefully selected and expertly prepared for an unforgettable dining experience."));
        list.add(new ItemModel(R.drawable.fish,"Fresho Pangas Fish(500mg)","179","Dive into a sea of flavors with our freshly caught fish, delivering a burst of oceanic goodness to satisfy your seafood cravings."));
        list.add(new ItemModel(R.drawable.prawns,"White Prawns(500mg) ","489","Delight in the succulent and exquisite taste of our plump, juicy prawns, a culinary treasure from the sea that will elevate your dishes to gourmet perfection."));

        itemAdapter=new ItemAdapter(list,this);
        recyclerView.setAdapter(itemAdapter);
    }
}