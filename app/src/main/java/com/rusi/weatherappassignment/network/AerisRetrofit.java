package com.rusi.weatherappassignment.network;

import android.util.Log;

import com.rusi.weatherappassignment.network.JSON.ResponseAeris;
import com.rusi.weatherappassignment.utility.CONSTANTS;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AerisRetrofit {
	private static AerisRetrofit aerisRetrofit;
	private retrofit2.Retrofit retrofit;


	private  AerisRetrofit(){}

	public static AerisRetrofit getInstance(){
		if (aerisRetrofit == null){
			aerisRetrofit = new AerisRetrofit();
		}
		return aerisRetrofit;
	}

	private AerisInterface connect () {
		if (retrofit == null) {
			retrofit = new retrofit2.Retrofit.Builder()
				  .baseUrl(CONSTANTS.AERIS_WEATHER.BASE_URL)
				  .addConverterFactory(GsonConverterFactory.create())
				  .build();
		}
		AerisInterface aerisRetrofitCall = retrofit.create(AerisInterface.class);

		return aerisRetrofitCall;
	}

	public void getAerisResponse (String client_id, String secret_id) {

		AerisInterface aerisRetrofitCall = connect();
		Call<ResponseAeris> getResponse = aerisRetrofitCall.getForecasts(client_id, secret_id);
		getResponse.enqueue(new Callback<ResponseAeris>() {
			@Override
			public void onResponse (Call <ResponseAeris> call, Response<ResponseAeris> response) {
				ResponseAeris jsonResponse = response.body();
				Log.d("URL: ", call.request().url().toString());
			}

			@Override
			public void onFailure (Call <ResponseAeris> call, Throwable t) {
				Log.d("onFailure: ", t.toString());
			}
		});
	}
}
