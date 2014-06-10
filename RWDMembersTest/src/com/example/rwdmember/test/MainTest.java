package com.example.rwdmember.test;

import com.example.rwdmember.MainActivity;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class MainTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo mySolo;
	public MainTest() {
		super(MainActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		mySolo = new Solo(getInstrumentation(), getActivity());
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testActionBarItems() {
		mySolo.clickOnActionBarItem(0); //Scanner
		mySolo.clickOnActionBarItem(1); //Member
		mySolo.clickOnActionBarItem(2); //Statistic
	}
	
	/*public void testActionBarScroll() {
		mySolo.scrollViewToSide(mySolo.getView(0), mySolo.RIGHT);
	}*/
	
	public void testButton() {
		mySolo.clickOnActionBarItem(0);
		mySolo.clickOnButton("Scan");
	}
	
	public void testMenuList() {
		mySolo.clickOnMenuItem("Settings");
		mySolo.clickOnMenuItem("Save to File");
	}
	
	//---Scan the Member Card of Member01 Rieger for positive result
	//---Requires testing with an android mobile phone
	public void testInputField() {
		mySolo.clickOnButton("Scan");
		
		String strIn = "1011002051001";
		
		boolean test_input = mySolo.searchEditText(strIn);
		
		assertEquals("text is not matched", true, test_input);
	}
	
	public void testMemberView() {
		mySolo.clickOnActionBarItem(1);
		mySolo.clickOnMenuItem("Open CSV File");
		
		
	}
}
