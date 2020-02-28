package com.rizwanindustries.cardviewpagertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.rizwanindustries.cardviewpagertest.Model.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);

        modelList = new ArrayList<>();
        modelList.add(new Model(R.drawable.example1, "Example 1", "Description Example1"));
        modelList.add(new Model(R.drawable.example2, "Example 2", "Description Example2"));
        modelList.add(new Model(R.drawable.example3, "Example 3", "Description Example3"));
        modelList.add(new Model(R.drawable.example4, "Example 4", "Description Example4"));
        modelList.add(new Model(R.drawable.example5, "Example 5", "Description Example5"));
        modelList.add(new Model(R.drawable.example6, "Example 6", "Description Example6"));
        modelList.add(new Model(R.drawable.example7, "Example 7", "Description Example7"));

        setAdapter();
        //addData();

    }

    public void addData(){

    }

    public void setAdapter(){
        adapter = new Adapter(this, modelList);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);
    }
}
