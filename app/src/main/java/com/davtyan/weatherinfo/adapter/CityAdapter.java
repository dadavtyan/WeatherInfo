package com.davtyan.weatherinfo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davtyan.weatherinfo.R;
import com.davtyan.weatherinfo.activitys.WeatherActivity;
import com.davtyan.weatherinfo.model.City;
import com.google.gson.Gson;

import java.util.List;


public class CityAdapter extends RecyclerView.Adapter<CityHolder>{

    private Context context;
    private List<City> cities;
    private View view;

    public CityAdapter(Context context, List<City> cities) {
        this.context = context;
        this.cities = cities;
    }

    @Override
    public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_list, parent, false);
        CityHolder cityHolder = new CityHolder(view);

        return cityHolder;
    }

    @Override
    public void onBindViewHolder(CityHolder holder, final int position) {
        holder.initData(cities.get(position));
        final City city = cities.get(position);
        holder.getName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItem(city);

            }
        });
    }

    private void getItem(City city) {
        Intent intent= new Intent(context, WeatherActivity.class);
        intent.putExtra("city",new Gson().toJson(city));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }
}
