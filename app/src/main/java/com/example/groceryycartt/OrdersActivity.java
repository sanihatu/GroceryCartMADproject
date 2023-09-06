package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groceryycartt.Adapters.ItemAdapter;
import com.example.groceryycartt.Adapters.OrdersAdapter;
import com.example.groceryycartt.Models.ItemModel;
import com.example.groceryycartt.Models.OrdersModel;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    TextView TotalPrice;
    Button Checkout;
    ImageButton back;
    DBHelper DB;

    ArrayList<OrdersModel> list;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        recyclerView = findViewById(R.id.orderRecyclerView);
        TotalPrice = findViewById(R.id.TotalPrice);
        Checkout = findViewById(R.id.checkoutBtn);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        String shopname = sharedPreferences.getString("shopname", "").toString();


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        DB = new DBHelper(this);
        ArrayList<OrdersModel> list = DB.getOrderData(username);

        OrdersAdapter adapter = new OrdersAdapter(list, this);
        recyclerView.setAdapter(adapter);
        int sum=0,i;
        for(i=0;i<list.size();i++){
            sum+=Integer.parseInt(list.get(i).getPrice());
        }
        TotalPrice.setText(""+sum);

        Checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OrdersActivity.this, CheckoutActivity.class);
                intent.putExtra("price",TotalPrice.getText());
                startActivity(intent);
            }
        });
        back=findViewById(R.id.backorders);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
            }
        });

    }
}

