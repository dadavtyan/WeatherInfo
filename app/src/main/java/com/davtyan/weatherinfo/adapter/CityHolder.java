package com.davtyan.weatherinfo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.davtyan.weatherinfo.R;
import com.davtyan.weatherinfo.model.City;




public class CityHolder extends RecyclerView.ViewHolder{
    private TextView cityName;
    private String countryName;
    public CityHolder(View itemView) {
        super(itemView);
        cityName = itemView.findViewById(R.id.city_name);
    }

    public void initData(City city){
        countryName = city.getSys().getCountry();
        cityName.setText( countryName + ": " + city.getName());
    }

    public TextView getName() {
        return cityName;
    }
}
