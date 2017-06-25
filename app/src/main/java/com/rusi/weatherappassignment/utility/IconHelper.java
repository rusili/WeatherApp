package com.rusi.weatherappassignment.utility;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rusi.weatherappassignment.R;

public class IconHelper {
	private static IconHelper iconHelper;

	private IconHelper(){}

	public static IconHelper getInstance(){
		if (iconHelper == null){
			iconHelper = new IconHelper();
		}
		return  iconHelper;
	}

	public void chooseIcon (String icon, ImageView imageViewIcon){
		icon = icon.substring(0, icon.length()-4);
		int resID = imageViewIcon.getContext().getResources().getIdentifier(icon, "drawable", imageViewIcon.getContext().getPackageName());
		Log.d("iconID: ", String.valueOf(resID));

		Glide.with(imageViewIcon.getContext())
			  .load(resID)
			  .fitCenter()
			  .placeholder(R.drawable.ic_loop_black_24dp)
			  .into(imageViewIcon);
	}
}
