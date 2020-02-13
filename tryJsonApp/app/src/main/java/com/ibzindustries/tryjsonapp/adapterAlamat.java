package com.ibzindustries.tryjsonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class adapterAlamat extends ArrayAdapter {
    private Context mContext;
    private ArrayList<Alamat> alamats;

    public adapterAlamat(@NonNull Context context, ArrayList<Alamat> alamats) {
        super(context, 0, alamats);
        this.mContext = context;
        this.alamats = alamats;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.data_listview, parent, false);

        Alamat alamat = alamats.get(position);

        TextView tvName, tvDetail, tvCity;

        tvName = convertView.findViewById(R.id.address_name);
        tvDetail = convertView.findViewById(R.id.address_detail);
        tvCity = convertView.findViewById(R.id.address_city);

        tvName.setText(alamat.getNamaAlamat());
        tvDetail.setText(alamat.getAlamatLengkap());
        tvCity.setText(alamat.getNamaKota());

        return  convertView;
    }
}
