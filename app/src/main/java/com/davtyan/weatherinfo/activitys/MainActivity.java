package com.davtyan.weatherinfo.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.davtyan.weatherinfo.JsonTask;
import com.davtyan.weatherinfo.R;
import com.davtyan.weatherinfo.adapter.CityAdapter;
import com.davtyan.weatherinfo.model.City;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new JsonTask(this).execute();

    }


    public void setAdapter(List<City> cities) {
        recyclerView.setAdapter(new CityAdapter(this,cities));
    }
}
