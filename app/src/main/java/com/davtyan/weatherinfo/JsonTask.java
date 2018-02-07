package com.davtyan.weatherinfo;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.davtyan.weatherinfo.activitys.MainActivity;
import com.davtyan.weatherinfo.model.City;

import java.util.List;

public class JsonTask extends AsyncTask<Void,Void,List<City>> {
    private MainActivity activity;


    public JsonTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected List<City> doInBackground(Void... voids) {
        return new CityLoad().fetchItems();
    }

    @Override
    protected void onPostExecute(List<City> cities) {
        super.onPostExecute(cities);
        activity.setAdapter(cities);

    }

}