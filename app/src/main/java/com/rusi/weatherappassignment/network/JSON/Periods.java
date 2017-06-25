package com.rusi.weatherappassignment.network.JSON;

public class Periods {
	private String validTime;

	private int maxTempC;
	private int minTempC;
	private int MaxTempF;
	private int minTempF;

	private String icon;

	public String getValidTime () {
		return validTime;
	}

	public int getMaxTempC () {
		return maxTempC;
	}

	public int getMinTempC () {
		return minTempC;
	}

	public int getMaxTempF () {
		return MaxTempF;
	}

	public int getMinTempF () {
		return minTempF;
	}

	public String getIcon () {
		return icon;
	}
}
