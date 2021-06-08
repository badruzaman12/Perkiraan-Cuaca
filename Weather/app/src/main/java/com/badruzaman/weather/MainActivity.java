package com.badruzaman.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.badruzaman.weather.adapter.AdapterForecast;
import com.badruzaman.weather.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView wind, pressure, precip, humidity, cloud, gust, condition, temp, update, location;

    private RecyclerView mrecyclerView;
    private AdapterForecast adapterForecast;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wind = findViewById(R.id.wind_kph_current);
        pressure = findViewById(R.id.pressure_mb_current);
        precip = findViewById(R.id.precip_mm_current);
        humidity = findViewById(R.id.humidity_current);
        cloud = findViewById(R.id.cloud_current);
        gust = findViewById(R.id.gust_kph_current);
        condition = findViewById(R.id.condition_current);
        temp = findViewById(R.id.temp_c_current);
        update = findViewById(R.id.last_update_current);
        location = findViewById(R.id.location_current);


        mrecyclerView = (RecyclerView)findViewById(R.id.recycleviewForecast);

        mLayoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLayoutManager);

        getCurrentData();
        getForecastData();
    }

    private void getCurrentData(){

        ApiService.endPoint().getCurrentData()
                .enqueue(new Callback<CurrentModel>() {
                    @Override
                    public void onResponse(Call<CurrentModel> call, Response<CurrentModel> response) {

                        location.setText(response.body().getLocation().getName());
                        wind.setText("Wind : " + response.body().getCurrent().getWind_kph());
                        pressure.setText("Pressure : " + response.body().getCurrent().getPressure_mb());
                        precip.setText("Precip : " + response.body().getCurrent().getPrecip_mm());
                        humidity.setText("Humidity : " + response.body().getCurrent().getHumidity());
                        cloud.setText("Cloud : " + response.body().getCurrent().getCloud());
                        gust.setText("Gust : " + response.body().getCurrent().getGust_kph());
                        condition.setText(response.body().getCurrent().getCondition().getText());
                        temp.setText(response.body().getCurrent().getTemp_c());
                        update.setText(response.body().getCurrent().getLast_updated());

                    }

                    @Override
                    public void onFailure(Call<CurrentModel> call, Throwable t) {

                    }
                });

    }

    private void getForecastData(){
        ApiService.endPoint().getForecastData()
                .enqueue(new Callback<ForecastModel>() {
                    @Override
                    public void onResponse(Call<ForecastModel> call, Response<ForecastModel> response) {

                        List<Forecastday> forecastdays = response.body().getForecast().getForecastdayList();
                        Log.d("cek","jumlah data" + String.valueOf(forecastdays.size()));

                        adapterForecast = new AdapterForecast(forecastdays);
                        mrecyclerView.setAdapter(adapterForecast);

                        adapterForecast.setOnItemClickCallback(new AdapterForecast.OnItemClickCallback() {
                            @Override
                            public void onItemClicked(Forecastday data) {
                                showSelectedForecastday(data);
                            }
                        });

                    }

                    @Override
                    public void onFailure(Call<ForecastModel> call, Throwable t) {

                    }
                });
    }

    private void showSelectedForecastday(Forecastday forecastday) {

        Intent kirimData = new Intent(MainActivity.this, DetailActivity.class);
        kirimData.putExtra(DetailActivity.EXTRA_DATE, forecastday.getDate());
        kirimData.putExtra(DetailActivity.EXTRA_MAX_TEMP, forecastday.getDay().getMaxtemp_c());
        kirimData.putExtra(DetailActivity.EXTRA_MIN_TEMP, forecastday.getDay().getMintemp_c());
        kirimData.putExtra(DetailActivity.EXTRA_AVGTEMP,Double.toString(forecastday.getDay().getAvgtemp_c()));
        kirimData.putExtra(DetailActivity.EXTRA_MAX_WIND, forecastday.getDay().getMaxwind_kph());
        kirimData.putExtra(DetailActivity.EXTRA_TOTAL_PRECIP, forecastday.getDay().getTotalprecip_mm());
        kirimData.putExtra(DetailActivity.EXTRA_CONDITION, forecastday.getDay().getConditionForecast().getText());

        startActivity(kirimData);
    }
}