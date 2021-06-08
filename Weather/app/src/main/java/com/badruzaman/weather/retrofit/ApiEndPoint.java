package com.badruzaman.weather.retrofit;

import com.badruzaman.weather.CurrentModel;
import com.badruzaman.weather.ForecastModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("current.json?key= cbbf58ff79b34cfa8ad82918210406&q=Bekasi&aqi=no")
    Call<CurrentModel> getCurrentData();

    @GET("forecast.json?key=cbbf58ff79b34cfa8ad82918210406&q=Bekasi&days=3&aqi=no&alerts=no")
    Call<ForecastModel> getForecastData();

}
