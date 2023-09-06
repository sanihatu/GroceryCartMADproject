package com.example.groceryycartt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.groceryycartt.Adapters.ItemAdapter;
import com.example.groceryycartt.Adapters.Location1Adapter;
import com.example.groceryycartt.Models.ItemModel;
import com.example.groceryycartt.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    TextView order;

    ArrayList<ItemModel> list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item);
        order=findViewById(R.id.orders);

        display();

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ItemActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });

    }

    private void display() {
        recyclerView=findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list=new ArrayList<>();
        list.add(new ItemModel(R.drawable.eggs,"Eggs","60","White shell eggs laid by healthy hens."));
        list.add(new ItemModel(R.drawable.fish,"Catla","160","Sliced Fish"));
        list.add(new ItemModel(R.drawable.bread,"Bread","660","French bread"));
        list.add(new ItemModel(R.drawable.rice,"SonaMasoori","360","Best quality rice"));
        list.add(new ItemModel(R.drawable.apple,"Apple","180","Shimla Apple"));
        list.add(new ItemModel(R.drawable.banana,"Banana","65","Banana Yallakki"));
        itemAdapter=new ItemAdapter(list,this);
        recyclerView.setAdapter(itemAdapter);
    }


}