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

public class BakeryActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    TextView order;
    ImageButton back;

    ArrayList<ItemModel> list;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery);
        order=findViewById(R.id.orders);
        display();
        back=findViewById(R.id.backbakery);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BakeryActivity.this, OrdersActivity.class));
            }
        });
    }
    private void display() {
        recyclerView=findViewById(R.id.recylerview);
//            recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list=new ArrayList<>();
        list.add(new ItemModel(R.drawable.bread,"Bread (Pack of 1)","32","Discover the creamy delight of our handcrafted curd, a perfect balance of tanginess and smoothness."));
        list.add(new ItemModel(R.drawable.roll,"Malpani Cream Rolls(10pcs)","130","Experience pure bliss with our heavenly cream rolls, a delightful combination of fluffy pastry and luscious cream that will transport your taste buds to cloud nine."));
        list.add(new ItemModel(R.drawable.pastry,"Pastry(Pack of 4+2free)","339","Treat yourself to our irresistible pastries, a symphony of delicate flavors and flaky textures that will enchant your palate with every delectable bite."));
        list.add(new ItemModel(R.drawable.cake,"Cake(500 mg)","479","Indulge in pure decadence with our exquisite cakes, meticulously crafted to captivate your senses and create unforgettable moments of sweetness."));
        list.add(new ItemModel(R.drawable.cookies,"Parle Cookies(75mg)","40","Delight in the perfect balance of crispiness and chewiness with our delectable cookies, baked to perfection and ready to satisfy your sweet cravings."));

        itemAdapter=new ItemAdapter(list,this);
        recyclerView.setAdapter(itemAdapter);
    }
}