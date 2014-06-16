package com.example.rwdmember;

//import java.io.IOException;
//import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v13.app.FragmentPagerAdapter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
import android.widget.Toast;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {


	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v13.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
		
		
		//ListView lv = (ListView) findViewById(R.id.listView);

	    // This is a simple adapter that accepts as parameter
	    // Context
	    // Data list
	    // The row layout that is used during the row creation
	    // The keys used to retrieve the data
	    // The View id used to show the data. The key number and the view id must match

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.over_all, menu);
		return true;
	}
	final int ACTIVITY_CHOOSE_FILE = 1;
	final int PICK_REQUEST_CODE = 1;
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.menuitem_search:
	        search();
	        return true;
	    case R.id.menuitem_open:
	    	//--- Open File Dialog
	    	Intent chooseFile;
	    	Intent intent;
	    	chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
	    	chooseFile.setType("file/*");
	    	intent = Intent.createChooser(chooseFile, "Choose a .csv file");
	    	startActivityForResult(intent, ACTIVITY_CHOOSE_FILE);
	        return true;
	    case R.id.menuitem_save:
	        saveFile();
	        return true;
	    case R.id.action_settings:
	        Settings();
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }

	}
	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			
			switch (position) {
			case 0:	
				return Fragment_Scanner.newInstance(0);
			case 1:
				return Fragment_Member.newInstance(1);
			case 2:
				return Fragment_Statistic.newInstance(2);
			default: 
				return null;
			}
			
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}
	
	public void scanBarcode (View view){
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
	    ArrayList<Member> members = Read_CSV.getMemberList();
	    if (scanResult != null) {
	    	String barcode;
	    	barcode = scanResult.getContents();
	    	EditText etBarcode = (EditText) findViewById(R.id.etBarcode);
	    	
	    	for (int i = 0; i < members.size(); i++) {
	    		if (members.get(i).getBarcode().equals(barcode)) { 
	    			members.get(i).setSelected(true);
	    			etBarcode.setText(barcode);
	    			break;   			
//	    			Toast.makeText(getApplicationContext(), 
//	    			  members.get(i).getLastName() + " " + members.get(i).getFirstName() + " checked in!", Toast.LENGTH_LONG)
//	    			  .show();
	    		}
	    	}
	    	Read_CSV.setMemberList(members);
	    }
	    
	    switch(requestCode) {
			case ACTIVITY_CHOOSE_FILE: {
				if (resultCode == RESULT_OK){
					Uri uri = intent.getData();
					String filePath = uri.getPath();
					String[] pathFragments = filePath.split("/");
					filePath = "/sdcard";
					int i = 3;
					while (i < pathFragments.length) {
						filePath += "/" + pathFragments[i];
						i++;
					}
					Toast.makeText(getApplicationContext(), 
							filePath + " " + " is opened!", Toast.LENGTH_LONG).show();
					Read_CSV.readFile(filePath);					
				}
			}
		}
	    
	  // else continue with any other code you need in the method
	}
	
	public void search (){
		//Search name in Memberlist
	}
	
		
	public void saveFile (){
		//Save File as new CSV With option to set File name
	}
	
	public void Settings (){
		//Output for Settings
	}
	
	
}
