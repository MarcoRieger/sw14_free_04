package com.example.rwdmember;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.Map;

@SuppressLint("SdCardPath")
public class Read_CSV extends Activity {
	  List<Member> memberList = new ArrayList<Member>();  

	public static void readFile() {  
		  String csvFileToRead = "/sdcard/Namensliste.csv";  
		  BufferedReader br = null;  
		  String line = "";  
		  String splitBy = ",";  
		  List<Member> memberList = new ArrayList<Member>();  
		  
		  try {  
		  
		   br = new BufferedReader(new FileReader(csvFileToRead));  
		   while ((line = br.readLine()) != null) {  
		  
		    // split on comma(',')  
		    String[] members = line.split(splitBy);  
		  
		    // create car object to store values  
		    Member memberObject = new Member();  
		  
		    // add values from csv to car object  
		    memberObject.setFirstName(members[0]);  
		    memberObject.setLastName(members[1]);  
		    memberObject.setBarcode(members[2]);  
		    memberObject.setSelected(members[3]);  
		  
		    // adding car objects to a list  
		    memberList.add(memberObject);  
		  
		   } 
		   //values stored in memberList!!!  

		  } catch (FileNotFoundException e) {  
		   e.printStackTrace();  
		  } catch (IOException e) {  
		   e.printStackTrace();  
		  } finally {  
		   if (br != null) {  
		    try {  
		     br.close();  
		    } catch (IOException e) {  
		     e.printStackTrace();  
		    }  
		   }  
		  }  
		 }  
//Here we have a List of Members

}
