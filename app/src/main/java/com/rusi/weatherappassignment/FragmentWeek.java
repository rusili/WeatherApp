package com.rusi.weatherappassignment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rusi.weatherappassignment.utility.IconHelper;

public class FragmentWeek extends Fragment {
	private MainPresenter mainPresenter;
	private IconHelper iconHelper;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize();
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
