package com.badruzaman.weather;

import com.google.gson.annotations.SerializedName;

public class ForecastModel {

    @SerializedName("current")
    private Current fcCurrent;

    @SerializedName("location")
    private Location fcLocation;

    @SerializedName("forecast")
    private Forecast forecast;

    public Current getFcCurrent() {
        return fcCurrent;
    }

    public void setFcCurrent(Current fcCurrent) {
        this.fcCurrent = fcCurrent;
    }

    public Location getFcLocation() {
        return fcLocation;
    }

    public void setFcLocation(Location fcLocation) {
        this.fcLocation = fcLocation;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
