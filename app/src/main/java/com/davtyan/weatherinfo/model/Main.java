package com.davtyan.weatherinfo.model;


import java.io.Serializable;


public class Main implements Serializable {

    private double temp;

    private double pressure;

    private double humidity;

    public String getTemp() {
        return "Temp: " + String.valueOf(temp);
    }

    public String getPressure() {
        return "Pressure: " + String.valueOf(pressure);
    }

    public String getHumidity() {
        return "Humidity: " + String.valueOf((int) humidity);
    }


}
