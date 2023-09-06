package com.example.groceryycartt.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryycartt.CategoryActivity;
import com.example.groceryycartt.ItemActivity;
import com.example.groceryycartt.Models.Location1Model;
import com.example.groceryycartt.R;

import java.util.ArrayList;

public class Location1Adapter extends RecyclerView.Adapter<Location1Adapter.LocationViewHolder> {

    ArrayList<Location1Model> list;
    Context context;
    public String shoop;


    public Location1Adapter(ArrayList<Location1Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(LayoutInflater.from(context).inflate(R.layout.sample_location, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.shoppic.setImageResource(list.get(position).getImage());
        holder.shopname.setText(list.get(position).getShopname());
        holder.address.setText(list.get(position).getShopaddress());
        holder.phonenum.setText(list.get(position).getShopephone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(ArrayList<Location1Model> filteredList) {
        list = filteredList;
        notifyDataSetChanged();

    }

    public class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView shoppic;
        //                Context context;
        public TextView shopname, address, phonenum;

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            shoppic = itemView.findViewById(R.id.shopPic);
            shopname = itemView.findViewById(R.id.shopname);
            address = itemView.findViewById(R.id.address);
            phonenum = itemView.findViewById(R.id.phonenum);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
//            shooop= (String) shopname.getText();
//            shoop=shopname.getText().toString();
            Intent intent=new Intent(context, CategoryActivity.class);

            intent.putExtra("shopname",shopname.getText());
//            SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor=sharedPreferences.edit();
//            editor.putString("shopname",shopname.getText());
//            editor.apply();
            context.startActivity(intent);
        }
    }
}

