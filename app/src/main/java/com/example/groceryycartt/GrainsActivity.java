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

public class GrainsActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    TextView order;
    ImageButton back;

    ArrayList<ItemModel> list;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grains);
        order=findViewById(R.id.orders);
        display();
        back=findViewById(R.id.backgrains);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GrainsActivity.this, OrdersActivity.class));
            }
        });
    }
    private void display() {
        recyclerView=findViewById(R.id.recylerview);
//            recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list=new ArrayList<>();
        list.add(new ItemModel(R.drawable.rice,"Sona Masoori(pack of 1kg)","54","Premium rice, a staple grain that transforms every meal into a satisfying and wholesome experience."));
        list.add(new ItemModel(R.drawable.wheat,"Wheat(1kg)","46","Discover the nourishing essence of our high-quality wheat, a versatile grain that forms hearty and wholesome meal."));
        list.add(new ItemModel(R.drawable.toordal,"Toor Dal(1kg)","175","Top-quality toor dal, a protein-packed lentil that adds depth and flavor to your favorite traditional dishes."));
        list.add(new ItemModel(R.drawable.ragi,"Raagi(1Kg)","28","Gluten-free grain rich in calcium and fiber, perfect for promoting a healthy and balanced lifestyle."));
        list.add(new ItemModel(R.drawable.corn,"Country Corn(1kg)","70","Experience the golden sweetness of our farm-fresh country corn, plucked at its peak."));

        itemAdapter=new ItemAdapter(list,this);
        recyclerView.setAdapter(itemAdapter);
    }
}