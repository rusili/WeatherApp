package com.rusi.weatherappassignment.utility;

public class IconHelper {
	private static IconHelper iconHelper;

	private IconHelper(){}

	public static IconHelper getInstance(){
		if (iconHelper == null){
			iconHelper = new IconHelper();
		}
		return  iconHelper;
	}

	public void chooseIcon(String icon){

	}
}