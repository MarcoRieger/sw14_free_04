package com.example.rwdmembers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class ReadCSV {

	public static void read(String[] args) {

	  String strFile = "example.csv";
	 
	  BufferedReader br = new BufferedReader( new FileReader(strFile));
	  String strLine = "";
	  StringTokenizer st = null;
	  int lineNumber = 0;
	  int tokenNumber = 0;
	 
	  while( (strLine = br.readLine()) != null)
	  {
	      lineNumber++;
	     
	      st = new StringTokenizer(strLine, ",");
	 
	      while(st.hasMoreTokens())
	      {
	    	  tokenNumber++;
	    	  System.out.println("Line # " + lineNumber +
	    			  ", Token # " + tokenNumber
	    			  + ", Token : "+ st.nextToken());
	      }
	      tokenNumber = 0;     
	  }       
	}
}