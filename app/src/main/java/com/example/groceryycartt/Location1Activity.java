package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.groceryycartt.Adapters.Location1Adapter;
import com.example.groceryycartt.Models.Location1Model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Location1Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Location1Model> list;
    Location1Adapter location1Adapter;
     TextView ShopName;



    SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location1);
       searchView=findViewById(R.id.searchView);
       ShopName=findViewById(R.id.shopname);

//       String ShoopName=ShopName.getText().toString();
//        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("shopname",ShoopName);
//        editor.apply();

        displayItems();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        finishAffinity();
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }

    private void filter(String newText) {
        ArrayList<Location1Model> filteredlist=new ArrayList<>();
        for(Location1Model item:list){
            if(item.getShopaddress().toLowerCase().contains(newText.toLowerCase())){
                filteredlist.add(item);
            }
        }
        location1Adapter.filterList(filteredlist);
    }

    private void displayItems() {
        recyclerView=findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list=new ArrayList<>();
        list.add(new Location1Model(R.drawable.shop,"D Mart","Attavar","6364757171"));
        list.add(new Location1Model(R.drawable.shop,"Ragavendra Stores","Adyar","6547384637"));
        list.add(new Location1Model(R.drawable.shop,"C Mart","Adyar","6364757171"));
        list.add(new Location1Model(R.drawable.shop,"Annapurna Stores","Kannur","6364757171"));
        list.add(new Location1Model(R.drawable.shop,"Seema Departmental Stores","BC road","6364757171"));
        list.add(new Location1Model(R.drawable.shop,"Dayand","pumpwell","6364757171"));
        location1Adapter=new Location1Adapter(list,this);
        recyclerView.setAdapter(location1Adapter);

    }
}