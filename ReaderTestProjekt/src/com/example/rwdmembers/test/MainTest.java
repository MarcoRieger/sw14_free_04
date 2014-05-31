package com.example.rwdmembers.test;

import com.example.rwdmembers.BarcodeReader;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class MainTest extends ActivityInstrumentationTestCase2<BarcodeReader> {

	private Solo mySolo;
	public MainTest() {
		super(BarcodeReader.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		mySolo = new Solo(getInstrumentation(), getActivity());
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testReader()
	{
		mySolo.clickOnButton("Scan");
	}
}
