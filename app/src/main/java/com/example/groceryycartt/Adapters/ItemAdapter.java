package com.example.groceryycartt.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryycartt.DetailActivity;
import com.example.groceryycartt.Models.ItemModel;
import com.example.groceryycartt.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewholder> {
    ArrayList<ItemModel> list;
    Context context;

    public ItemAdapter(ArrayList<ItemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_item,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final ItemModel model=list.get(position);
        holder.itemImage.setImageResource(model.getItemImage());
        holder.itemName.setText(model.getItemName());
        holder.itemPrice.setText(model.getItemPrice());
        holder.itemdesp.setText(model.getItemDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getItemImage());
                intent.putExtra("name",model.getItemName());
                intent.putExtra("description",model.getItemDescription());
                intent.putExtra("price",model.getItemPrice());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName,itemPrice,itemdesp;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            itemImage=itemView.findViewById(R.id.itemPic);
            itemName=itemView.findViewById(R.id.itemname);
            itemPrice=itemView.findViewById(R.id.itemprice);
            itemdesp=itemView.findViewById(R.id.itemdescription);

        }
    }
}
