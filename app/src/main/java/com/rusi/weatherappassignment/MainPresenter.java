package com.rusi.weatherappassignment;

import com.rusi.weatherappassignment.network.AerisRetrofit;
import com.rusi.weatherappassignment.network.JSON.ResponseAeris;
import com.rusi.weatherappassignment.utility.CONSTANTS;

public class MainPresenter {
	private final FragmentWeek fragmentWeek;
	private static AerisRetrofit aerisRetrofit;
	private AerisRetrofit.RetrofitListener retrofitListener;

	public MainPresenter(FragmentWeek fragmentWeek){
		this.fragmentWeek = fragmentWeek;
	}

	public void makeNetworkCall () {
		aerisRetrofit = AerisRetrofit.getInstance();
		aerisRetrofit.setRetrofitListener(retrofitListener = new AerisRetrofit.RetrofitListener() {
			@Override
			public void onForecastsRetrieved (ResponseAeris jsonObject) {
				fragmentWeek.updateUI();
			}
		});
		aerisRetrofit.getAerisResponse(CONSTANTS.AERIS_WEATHER.CLIENT_ID, CONSTANTS.AERIS_WEATHER.SECRET_ID);
	}
}
