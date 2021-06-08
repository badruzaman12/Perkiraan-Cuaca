package com.badruzaman.weather;

import com.google.gson.annotations.SerializedName;

public class Condition {
    @SerializedName("icon")
    private String icon;

    @SerializedName("text")
    String text;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
