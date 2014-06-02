package com.example.rwdmember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import au.com.bytecode.opencsv.CSVReader;





@SuppressLint("SdCardPath")
public class Read_CSV extends ArrayAdapter<Member> {
	

	
	
	
	
	


	public Read_CSV(Context context, int resource, int textViewResourceId) {
		super(context, resource, textViewResourceId);
		// TODO Auto-generated constructor stub
	}

	public void readFile() throws IOException {

		
		try {
			// Get input stream and Buffered Reader for our data file.
			String csvFilename = "/sdcard/Namen_2.csv";
			@SuppressWarnings("resource")
			BufferedReader csvReader = new BufferedReader(new FileReader(csvFilename));
			String line;

			//Read each line
			while ((line = csvReader.readLine()) != null) {

				//Split to separate the name from the capital
				String[] RowData = line.split(",");

				//Create a State object for this row's data.
				Member cur = new Member();
				cur.setFirstName(RowData[0]);
				cur.setLastName(RowData[1]);
				cur.setBarcode(RowData[2]);
				cur.setSelected(RowData[3]);
			
				//Add the State object to the ArrayList (in this case we are the ArrayList).
				this.add(cur);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		/*		String csvFilename = "/sdcard/Namen_2.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
				List<String[]> Members = csvReader.readAll();

		ListView OneMember = (ListView) findViewById(R.id.listViewMember);
		OneMember.setAdapter(Members);
		*/
	
		
		
		
		
		
		
		
		
		
		
		
		/*
		String csvFile = "/sdcard/Namen_2.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFile));
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(csvFile));
		ArrayList<member> member = br.readLine();
		*/

	}

}
