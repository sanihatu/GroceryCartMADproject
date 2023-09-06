package com.example.groceryycartt.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryycartt.DBHelper;
import com.example.groceryycartt.Models.OrdersModel;
import com.example.groceryycartt.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder>{
    ArrayList<OrdersModel> list;
     Context context;





    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_orders, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final OrdersModel model = list.get(position);
        holder.orderImage.setImageResource(model.getImage());
        holder.orderName.setText(model.getName());
        holder.orderPrice.setText(model.getPrice());

            }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView orderImage;
//        Button delete;

        TextView orderName,orderDescription,orderPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage=itemView.findViewById(R.id.orderImage);
            orderName=itemView.findViewById(R.id.orderItemName);
            orderPrice=itemView.findViewById(R.id.orderPriceO);
//            delete=itemView.findViewById(R.id.deletebtn);




        }

    }
}
