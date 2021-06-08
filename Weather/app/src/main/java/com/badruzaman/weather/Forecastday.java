package com.badruzaman.weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Forecastday {

    @SerializedName("date")
    private String date;

    @SerializedName("day")
    private Day day;

    @SerializedName("astro")
    private Astro astro;

    @SerializedName("hour")
    private List<Hour> hourList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public List<Hour> getHourList() {
        return hourList;
    }

    public void setHourList(List<Hour> hourList) {
        this.hourList = hourList;
    }
}
