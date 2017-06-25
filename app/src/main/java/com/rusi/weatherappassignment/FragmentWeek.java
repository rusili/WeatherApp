package com.rusi.weatherappassignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusi.weatherappassignment.network.JSON.ResponseAeris;
import com.rusi.weatherappassignment.recyclerview.WeatherAdapter;
import com.rusi.weatherappassignment.utility.IconHelper;

public class FragmentWeek extends Fragment {
	private MainPresenter mainPresenter;
	private IconHelper iconHelper;

	private View view;
	private RecyclerView recyclerviewWeekdays;
	private WeatherAdapter weatherAdapter;

	@Nullable
	@Override
	public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_week, container, false);
		initialize();
		return view;
	}

	private void initialize () {
		mainPresenter = new MainPresenter(this);
		iconHelper = IconHelper.getInstance();
		setViews();
	}

	private void setViews () {
		recyclerviewWeekdays = (RecyclerView) view.findViewById(R.id.weekday_recyclerview);
		LinearLayoutManager linearLayoutManagerHorizontal = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
		recyclerviewWeekdays.setLayoutManager(linearLayoutManagerHorizontal);
		mainPresenter.makeNetworkCall();
	}

	public void updateUI (ResponseAeris jsonObject) {
		recyclerviewWeekdays.setAdapter(weatherAdapter = new WeatherAdapter(jsonObject));
	}

}
