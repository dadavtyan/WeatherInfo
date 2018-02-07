package com.davtyan.weatherinfo.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.davtyan.weatherinfo.R;
import com.davtyan.weatherinfo.model.City;
import com.google.gson.Gson;

public class WeatherActivity extends AppCompatActivity {

    private String json;
    private City city;

    private TextView tempMain, pressureMain, humidityMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_weather);

        if (getIntent().getStringExtra("city") != null) {
            json = (String) getIntent().getSerializableExtra("city");
            city = new Gson().fromJson(json, City.class);
            initView();
        }

    }

    private void initView() {
        tempMain = findViewById(R.id.tempMain);
        pressureMain = findViewById(R.id.pressureMain);
        humidityMain = findViewById(R.id.humidityMain);

        tempMain.setText(city.getMain().getTemp());
        pressureMain.setText(city.getMain().getPressure());
        humidityMain.setText(city.getMain().getHumidity());
    }

}
