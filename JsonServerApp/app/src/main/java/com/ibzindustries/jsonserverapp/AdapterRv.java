package com.ibzindustries.jsonserverapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibzindustries.jsonserverapp.modelClass.Product;

import java.util.ArrayList;

public class AdapterRv extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Product> products = new ArrayList<>();

    public Context getContext() {
        return context;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public AdapterRv(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
