package com.badruzaman.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATE = "extra_date_detai";
    public static final String EXTRA_MAX_TEMP = "extra_max_temp";
    public static final String EXTRA_MIN_TEMP = "extra_min_temp";
    public static final String EXTRA_AVGTEMP = "extra_avgtemp_detail";
    public static final String EXTRA_MAX_WIND = "extra_max_wind";
    public static final String EXTRA_TOTAL_PRECIP = "extra_total_precip";
    public static final String EXTRA_CONDITION = "extra_condition_detail";

    private TextView tglfc, maxtempfc, mintempfc, avgtempfc, maxwindfc, totalprecipfc, conditionfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tglfc = findViewById(R.id.datefc);
        maxtempfc = findViewById(R.id.maxtempfc);
        mintempfc = findViewById(R.id.mintempfc);
        avgtempfc = findViewById(R.id.avgtempfc);
        maxwindfc = findViewById(R.id.maxwindfc);
        totalprecipfc = findViewById(R.id.totalprecipfc);
        conditionfc = findViewById(R.id.conditionfc);

        String tanggal = getIntent().getStringExtra(EXTRA_DATE);
        String maxtemp = getIntent().getStringExtra(EXTRA_MAX_TEMP);
        String mintemp = getIntent().getStringExtra(EXTRA_MIN_TEMP);
        String avgtemp = getIntent().getStringExtra(EXTRA_AVGTEMP);
        String maxwind = getIntent().getStringExtra(EXTRA_MAX_WIND);
        String ttlprecip = getIntent().getStringExtra(EXTRA_TOTAL_PRECIP);
        String condition = getIntent().getStringExtra(EXTRA_CONDITION);

        tglfc.setText(tanggal);
        maxtempfc.setText(maxtemp);
        mintempfc.setText(mintemp);
        avgtempfc.setText(avgtemp);
        maxwindfc.setText(maxwind);
        totalprecipfc.setText(ttlprecip);
        conditionfc.setText(condition);
    }
}