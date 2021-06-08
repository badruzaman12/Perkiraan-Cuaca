package com.badruzaman.weather;

import com.google.gson.annotations.SerializedName;

public class Astro {

    @SerializedName("sunrise")
    private String sunrise;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
}
