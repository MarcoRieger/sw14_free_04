package com.example.rwdmember;
//See
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragment_Member extends Fragment {
	
	public static Fragment_Member newInstance(int sectionNumber) {
		Fragment_Member fragment = new Fragment_Member();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
		//Test
		
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_member, container,
				false);
		return rootView;
	}
	/*ListView lv = (ListView) findViewById(R.id.listView);
	simpleAdpt = new SimpleAdapter(this, memberList, android.R.layout.simple_list_item_1, 
			new int[] {android.R.id.text1});
	lv.setAdapter(simpleAdpt);*/
	
	


		
}
