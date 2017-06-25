package com.rusi.weatherappassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rusi.weatherappassignment.network.AerisRetrofit;
import com.rusi.weatherappassignment.network.JSON.ResponseAeris;
import com.rusi.weatherappassignment.utility.CONSTANTS;

public class ActivityMain extends AppCompatActivity {
	private AerisRetrofit aerisRetrofit;
	private AerisRetrofit.RetrofitListener retrofitListener;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		makeNetworkCall();
	}

	private void makeNetworkCall () {
		aerisRetrofit = AerisRetrofit.getInstance();
		aerisRetrofit.setRetrofitListener(retrofitListener = new AerisRetrofit.RetrofitListener() {
			@Override
			public void onForecastsRetrieved (ResponseAeris jsonObject) {
				// Update UI
			}
		});
		aerisRetrofit.getAerisResponse(CONSTANTS.AERIS_WEATHER.CLIENT_ID, CONSTANTS.AERIS_WEATHER.SECRET_ID);
	}
}
