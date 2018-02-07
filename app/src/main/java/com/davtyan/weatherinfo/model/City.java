package com.davtyan.weatherinfo.model;

import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private Sys sys;
    private Main main ;

    public City() {
    }

    public String getName() {
        return name;
    }

    public Sys getSys() {
        return sys;
    }


    public Main getMain() {
        return main;
    }


}
