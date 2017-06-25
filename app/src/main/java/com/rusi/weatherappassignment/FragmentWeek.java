package com.rusi.weatherappassignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusi.weatherappassignment.utility.IconHelper;

public class FragmentWeek extends Fragment {
	private MainPresenter mainPresenter;
	private IconHelper iconHelper;

	private View view;

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

	}

	public void updateUI () {
		// Update UI
	}

}
