package com.badruzaman.weather;

import com.google.gson.annotations.SerializedName;

public class Hour {

    @SerializedName("time")
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
