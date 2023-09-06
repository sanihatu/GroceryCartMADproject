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

public class FruitsveggiActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    TextView order;
    ImageButton back;
    ArrayList<ItemModel> list;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruitsveggi);
        order = findViewById(R.id.orders);
        display();
        back=findViewById(R.id.backfruitsveggi);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FruitsveggiActivity.this, OrdersActivity.class));
            }
        });

    }

    private void display() {
        recyclerView = findViewById(R.id.recylerview);
//            recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        list = new ArrayList<>();
        list.add(new ItemModel(R.drawable.apple, "Apple(1kg)", "180", "Experience the crisp and refreshing taste of our freshly picked apples, nature's gift of sweetness and health in every bite."));
        list.add(new ItemModel(R.drawable.banana, "Banana(1kg)", "79", "Savor the natural sweetness and velvety texture of our ripe bananas, a potassium-packed snack that brings a smile to your taste buds and nourishment to your body."));
        list.add(new ItemModel(R.drawable.mango, "Mango(1kg)", "70", "Indulge in the tropical paradise with our luscious mangoes, juicy and fragrant, delivering a burst of exotic flavor "));
        list.add(new ItemModel(R.drawable.orange, "Oranges(1kg)", "109", "Experience a burst of citrusy sunshine with our juicy oranges, packed with vitamin C and a zesty flavor"));
        list.add(new ItemModel(R.drawable.grapes, "Seedless Grapes(1kg)", "175", "Delight in the succulent juiciness of our plump grapes, a tantalizing medley of sweet and tangy flavors that make for a refreshing snack"));
        list.add(new ItemModel(R.drawable.carrot, "Carrots(1kg)", "98", "Discover the vibrant and nutritious allure of our freshly harvested carrots, offering a crisp and earthy sweetness"));
        list.add(new ItemModel(R.drawable.onion, "Onion(1kg)", "30", "Aromatic and versatile onions, a staple ingredient that adds depth and character to every dish"));
        list.add(new ItemModel(R.drawable.potato, "Potato(1kg)", "34", "Premium potatoes, the perfect foundation for a multitude of delicious dishes, from crispy fries to creamy mash."));
        list.add(new ItemModel(R.drawable.tomato, "Tomato(1kg)", "40", "Vibrant and juicy tomatoes, bursting with flavor and versatility to enhance your dishes and bring freshness to your meals."));
        list.add(new ItemModel(R.drawable.greenchilli, "Green Chilli(1kg)", "142", "Fiery and vibrant green chillies, adding a bold kick of spice and an electrifying flavor to your taste"));
        itemAdapter = new ItemAdapter(list, this);
        recyclerView.setAdapter(itemAdapter);
    }
}