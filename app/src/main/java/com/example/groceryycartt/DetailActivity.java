package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    ImageView detailImage,plusQuantity,minusQuantity;
    TextView detailName,detailDescription,detailPrice,quantitynumber;
    Button insertbtn;
    String Totalprice;
    int quantity,basePrice;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final DBHelper db = new DBHelper(this);
        detailImage=findViewById(R.id.detailimage);
        plusQuantity=findViewById(R.id.add);
        minusQuantity=findViewById(R.id.subtract);
        detailName=findViewById(R.id.detailname);
        detailDescription=findViewById(R.id.detailDescription);
        detailPrice=findViewById(R.id.detailprice);
        insertbtn=findViewById(R.id.insertBtn);
        quantitynumber=findViewById(R.id.detailquantity);

        final int image = getIntent().getIntExtra("image", 0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("description");
//        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
//        String username=sharedPreferences.getString("username","").toString();


        detailImage.setImageResource(image);
        detailPrice.setText(String.format("%d",price));
        detailName.setText(name);
        detailDescription.setText(description);


        int basePrice= Integer.parseInt(detailPrice.getText().toString());

        plusQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int basePrice=5;
                quantity++;
                displayQuantity();

                int itemPrice=basePrice*quantity;
                String setnewPrice=String.valueOf(itemPrice);
                detailPrice.setText(setnewPrice);

            }
        });
        minusQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int basePrice=5;
                if(quantity==0){
                    Toast.makeText(DetailActivity.this, "Can't decrease quantity < 0", Toast.LENGTH_SHORT).show();
                }else{
                    quantity--;
                    displayQuantity();
                    int itemPrice=basePrice*quantity;
                    String setnewPrice=String.valueOf(itemPrice);
                    detailPrice.setText(setnewPrice);
                }

            }
        });

//        int TotalPrice= Integer.parseInt(detailPrice.getText().toString());

        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                String shopname=sharedPreferences.getString("shopname","").toString();
                Totalprice=detailPrice.getText().toString();
                if(db.checkOrder(username,name)==1){
                    Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();
                }else{
                    db.insertorder(username,shopname, Integer.parseInt(Totalprice),image,description,name);
                    Toast.makeText(getApplicationContext(), "Added to Cart", Toast.LENGTH_SHORT).show();

                }
//                boolean isInserted = helper.insertorder(
//                        price,
//                        image,
//                        description,
//                        name
//
//
//                );
//                if(isInserted){
//                    Toast.makeText(DetailActivity.this, "Added to cart", Toast.LENGTH_LONG).show();
//                }
//                else{
//                    Toast.makeText(DetailActivity.this, "error", Toast.LENGTH_SHORT).show();
//                }
            }
        });



    }



    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }
    }
