package com.badruzaman.weather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.badruzaman.weather.Forecastday;
import com.badruzaman.weather.R;

import java.util.List;

public class AdapterForecast extends RecyclerView.Adapter<AdapterForecast.MyViewHolder> {

    List<Forecastday> mforecastdays;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public AdapterForecast (List<Forecastday> forecastdays){

        mforecastdays = forecastdays;
    }

    @Override
    public AdapterForecast.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fc, parent, false);
        MyViewHolder listViewHolder = new MyViewHolder(mView);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder( AdapterForecast.MyViewHolder holder, int position) {

        holder.fcDay.setText(mforecastdays.get(position).getDate());
        holder.fcAvgtemp.setText(Double.toString(mforecastdays.get(position).getDay().getAvgtemp_c()));
        holder.fcCondition.setText(mforecastdays.get(position).getDay().getConditionForecast().getText());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onItemClickCallback.onItemClicked(mforecastdays.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mforecastdays.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView fcDay, fcCondition, fcAvgtemp;

        public MyViewHolder( View itemView) {
            super(itemView);

            fcDay = itemView.findViewById(R.id.forecast_day);
            fcAvgtemp = itemView.findViewById(R.id.forecast_avgtemp);
            fcCondition = itemView.findViewById(R.id.forecast_condition);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Forecastday data);
    }
}
