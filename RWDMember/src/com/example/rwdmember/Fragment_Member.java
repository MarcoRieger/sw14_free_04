package com.example.rwdmember;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Member extends Fragment {
	
	public static Fragment_Member newInstance(int sectionNumber) {
		Fragment_Member fragment = new Fragment_Member();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_member, container,
				false);
		/*TextView textView = (TextView) rootView
				.findViewById(R.id.section_label);
		textView.setText(Integer.toString(getArguments().getInt(
				ARG_SECTION_NUMBER)));*/
		return rootView;
	}
	
		
}
