package com.rusi.weatherappassignment.network;

import com.rusi.weatherappassignment.network.JSON.ResponseAeris;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AerisInterface {

	@GET ("forecasts/11101")
	Call<ResponseAeris> getForecasts (@Query ("client_id") String CLIENT_ID, @Query ("client_secret") String CLIENT_SECRET);
}
