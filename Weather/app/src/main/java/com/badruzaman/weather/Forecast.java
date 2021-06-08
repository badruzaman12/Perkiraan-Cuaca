package com.badruzaman.weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {
    @SerializedName("forecastday")
    private List<Forecastday> forecastdayList;

    public List<Forecastday> getForecastdayList() {
        return forecastdayList;
    }

    public void setForecastdayList(List<Forecastday> forecastdayList) {
        this.forecastdayList = forecastdayList;
    }
}
