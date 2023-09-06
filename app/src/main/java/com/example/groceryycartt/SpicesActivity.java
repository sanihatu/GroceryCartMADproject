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

public class SpicesActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    TextView order;
    ImageButton back;

    ArrayList<ItemModel> list;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spices);
        order=findViewById(R.id.orders);
        display();
        back=findViewById(R.id.backspices);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SpicesActivity.this, OrdersActivity.class));
            }
        });
    }
    private void display() {
        recyclerView=findViewById(R.id.recylerview);
//            recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list=new ArrayList<>();
        list.add(new ItemModel(R.drawable.chillipowder,"MTR chilli powder(100mg)","66","Buy Red Chilli Powder Online in Bangalore. Homemade Red Chilli Powder now to your doorstep"));
        list.add(new ItemModel(R.drawable.salt,"Tata Salt(Pack of 1)","24","Enhance the taste of your dishes with our pure and pristine salt, sourced from the finest natural reserves"));
        list.add(new ItemModel(R.drawable.pepper,"Everest Black Pepper Powder(50mg)","80","Finely ground pepper powder, perfect for elevating the flavor profile of your favorite dishes."));
        list.add(new ItemModel(R.drawable.chaat,"Aachi Chaat Masala(pack of 1)","27","Tantalizing blend of spices that adds a burst of tanginess and zest to your savory snacks and street food "));
        list.add(new ItemModel(R.drawable.garammasala,"Eastern Garam Masala(pack of 1)","72","A perfect blend of spices that elevates your dishes with its rich, warm flavors, transporting your taste buds to culinary bliss."));
        list.add(new ItemModel(R.drawable.turmeric,"Caster Turmeric Powder(50mg)","35","Golden goodness of our premium turmeric powder, renowned for its vibrant color, earthy aroma, and versatile health benefits"));

        itemAdapter=new ItemAdapter(list,this);
        recyclerView.setAdapter(itemAdapter);
    }
}