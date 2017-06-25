package com.rusi.weatherappassignment.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
		textViewDate.setText(periods.getValidTime());
		if (CONSTANTS.celsius){
			textViewHighTemp.setText(String.valueOf(periods.getMaxTempC()) + CONSTANTS.SYMBOLS.DEGREE);
			textViewLowTemp.setText(String.valueOf(periods.getMinTempC()) + CONSTANTS.SYMBOLS.DEGREE);
		} else {
			textViewHighTemp.setText(String.valueOf(periods.getMaxTempF()) + CONSTANTS.SYMBOLS.DEGREE);
			textViewLowTemp.setText(String.valueOf(periods.getMinTempF()) + CONSTANTS.SYMBOLS.DEGREE);
		}

		displayIcon(periods);
	}

	private void displayIcon (Periods periods) {
		String imageName = periods.getIcon();
		Log.d("icon: ", imageName);
		int resID = view.getContext().getResources().getIdentifier(imageName, "drawable", view.getContext().getPackageName());
		Log.d("iconID: ", String.valueOf(resID));

		Glide.with(view.getContext())
			  .load(resID)
			  .fitCenter()
			  .placeholder(R.drawable.ic_loop_black_24dp)
			  .into(imageViewIcon);
	}
}
