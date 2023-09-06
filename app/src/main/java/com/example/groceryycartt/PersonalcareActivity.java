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

public class PersonalcareActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    TextView order;
    ImageButton back;
    ArrayList<ItemModel> list;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcare);
        order=findViewById(R.id.orders);
        display();
        back=findViewById(R.id.backpersonalcare);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonalcareActivity.this, OrdersActivity.class));
            }
        });
    }
    private void display() {
        recyclerView=findViewById(R.id.recylerview);
//            recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list=new ArrayList<>();
        list.add(new ItemModel(R.drawable.shampoo,"Clinic Plus Shampoo (pack of 1)","2","Transform your hair care routine with our nourishing shampoo, expertly formulated to cleanse, revive, and leave your locks irresistibly soft and lustrous."));
        list.add(new ItemModel(R.drawable.toothpaste,"Dabur Tooth paste( pack of 1)","20","Refreshing and confident smile with our premium toothpaste, specially crafted to protect and brighten your teeth, ensuring oral hygiene and a dazzling shine."));
        list.add(new ItemModel(R.drawable.soap,"Lifebuoy Soap (Pack of 1)","37","Gentle body soap, delicately scented and enriched with nourishing ingredients to leave your skin feeling rejuvenated"));
        list.add(new ItemModel(R.drawable.daiper,"Huggies Daipers(Pack of 1)","267","Wrap your little one in comfort and care with our premium baby diapers, designed for optimal protection and softness"));
        list.add(new ItemModel(R.drawable.babypowder,"Jhonson's Baby Powder(100 mg)","70","Delicate and soothing, our baby powder gently caresses your little one's skin, leaving it soft, dry, and pleasantly scented,"));
        list.add(new ItemModel(R.drawable.babysoap,"Jhonson's Baby Soap(150 mg)","105","Pamper your little one with our gentle baby soap, meticulously formulated to cleanse and nourish delicate skin"));

        itemAdapter=new ItemAdapter(list,this);
        recyclerView.setAdapter(itemAdapter);
    }
}