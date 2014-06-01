package com.example.rwdmember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import au.com.bytecode.opencsv.CSVReader;




public class Read_CSV extends Activity {
	

	//@SuppressLint("SdCardPath")
	@SuppressWarnings("resource")
	public void readFile() throws IOException {
/*		String csvFilename = "/sdcard/Namen_2.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
				List<String[]> Members = csvReader.readAll();

		ListView OneMember = (ListView) findViewById(R.id.listViewMember);
		OneMember.setAdapter(Members);
		*/
		
		String csvFile = "/sdcard/Namen_2.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		String country = "";
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
 
		        // use comma as separator
			
				country += line;
				country+= cvsSplitBy;
		}
			
			
			
	    //ListView allMember = (ListView) findViewById(R.id.listViewMember);
	    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
             //   android.R.layout.simple_list_item_1, Members.get(1));
	  // allMember.setAdapter(Members);

	    /*
	    List<String> firstColumn = new ArrayList<String>();
	    for (String[] row : acNames) {
	        firstColumn.add(row[0]);
	    }
	    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getBaseContext(), R.layout.listitem, firstColumn);
	    */
	    
	    
		//csvFile.close();
	}

}
