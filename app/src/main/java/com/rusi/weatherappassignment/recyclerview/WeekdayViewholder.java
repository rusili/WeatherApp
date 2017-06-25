package com.rusi.weatherappassignment.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rusi.weatherappassignment.R;
import com.rusi.weatherappassignment.network.JSON.Periods;
import com.rusi.weatherappassignment.utility.CONSTANTS;
import com.rusi.weatherappassignment.utility.IconHelper;

public class WeekdayViewholder extends RecyclerView.ViewHolder {
	private IconHelper iconHelper;

	private View view;
	private TextView textViewDate;
	private ImageView imageViewIcon;
	private TextView textViewHighTemp;
	private TextView textViewLowTemp;

	public WeekdayViewholder (View itemView, IconHelper iconHelper) {
		super(itemView);
		this.view = itemView;
		this.iconHelper = iconHelper;

		setViews();
	}

	private void setViews () {
		textViewDate = (TextView) view.findViewById(R.id.weekday_date);
		imageViewIcon = (ImageView) view.findViewById(R.id.weekday_icon);
		textViewHighTemp = (TextView) view.findViewById(R.id.weekday_hightemp);
		textViewLowTemp = (TextView) view.findViewById(R.id.weekday_lowtemp);
	}

	public void bind (Periods periods) {
		String maxTemp;
		String minTemp;

		textViewDate.setText(periods.getValidTime().substring(0, 10));

		if (CONSTANTS.celsius){
			maxTemp = periods.getMaxTempC() + CONSTANTS.SYMBOLS.DEGREE + "C";
			minTemp = periods.getMinTempC() + CONSTANTS.SYMBOLS.DEGREE + "C";
		} else {
			maxTemp = periods.getMaxTempF() + CONSTANTS.SYMBOLS.DEGREE + "F";
			minTemp = periods.getMinTempF() + CONSTANTS.SYMBOLS.DEGREE + "F";
		}
		textViewHighTemp.setText("High: " + maxTemp);
		textViewLowTemp.setText("Low: " + minTemp);

		iconHelper.chooseIcon(periods.getIcon(), imageViewIcon);
	}
}
