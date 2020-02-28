package com.rizwanindustries.cardviewpagertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.rizwanindustries.cardviewpagertest.Model.Model;

import java.util.List;

public class Adapter extends PagerAdapter {

    private Context context;
    private List<Model> models;

    public Adapter(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView image;
        TextView tittle, desc;

        image= view.findViewById(R.id.image);
        tittle = view.findViewById(R.id.tittle);
        desc = view.findViewById(R.id.desc);

        image.setImageResource(models.get(position).getImage());
        tittle.setText(models.get(position).getTittle());
        desc.setText(models.get(position).getDesc());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
