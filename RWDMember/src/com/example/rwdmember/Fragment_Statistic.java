package com.example.rwdmember;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Statistic extends Fragment {
	
	public static Fragment_Statistic newInstance(int sectionNumber) {
		Fragment_Statistic fragment = new Fragment_Statistic();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_statistic, container,
				false);
		return rootView;
	}
}