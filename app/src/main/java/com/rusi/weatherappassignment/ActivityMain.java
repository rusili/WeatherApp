package com.rusi.weatherappassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {
	private int containerID;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		containerID = R.id.Fragment_container;

		createFragmentWeek();
	}

	private void createFragmentWeek () {
		FragmentWeek fragmentWeek = new FragmentWeek();
		getSupportFragmentManager().beginTransaction()
			  .add(containerID, fragmentWeek, "Week")
			  .commit();
	}


}
