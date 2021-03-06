package com.rusi.weatherappassignment.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusi.weatherappassignment.R;
import com.rusi.weatherappassignment.network.JSON.Periods;
import com.rusi.weatherappassignment.network.JSON.ResponseAeris;
import com.rusi.weatherappassignment.utility.IconHelper;

public class WeatherAdapter extends RecyclerView.Adapter {
	Periods[] periodsArray = new Periods[7];

	private IconHelper iconHelper;

	public WeatherAdapter (ResponseAeris jsonObject) {
		this.periodsArray = jsonObject.getResponse()[0].getPeriods();
		iconHelper = IconHelper.getInstance();
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.weekday_viewholder, parent, false);
		WeekdayViewholder weekdayViewholder = new WeekdayViewholder(view, iconHelper);

		return weekdayViewholder;
	}

	@Override
	public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
		WeekdayViewholder weekdayViewholder = (WeekdayViewholder) holder;
		weekdayViewholder.bind(periodsArray[position]);
	}

	@Override
	public int getItemCount () {
		return periodsArray.length;
	}
}
