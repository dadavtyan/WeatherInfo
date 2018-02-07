package com.davtyan.weatherinfo;

import android.util.Log;

import com.davtyan.weatherinfo.model.City;
import com.davtyan.weatherinfo.model.Main;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CityLoad {


    private String getJsonData(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public List<City> fetchItems() {
        List<City> cities = new ArrayList<>();

        String url = "http://samples.openweathermap.org/data/2.5/group?id=524901,703448,2643743&units=metric&appid=dd33428c96d544ffc6941ce4b2e82362";
        Log.i("result","logo");
        String json = null;
        try {
            json = getJsonData(url);
            Log.i("result","log");
            JSONObject jsonObject = new JSONObject(json);
            parseItem(cities, jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }
    private void parseItem(List<City> cities, JSONObject jsonObject)
            throws IOException, JSONException {
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            City city = gson.fromJson(object.toString(), City.class);
            cities.add(city);
        }
    }
}
