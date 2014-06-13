package com.example.rwdmember;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


@SuppressLint("SdCardPath")
public class Read_CSV extends ListActivity {
	
	private static ArrayList<Member> memberList = new ArrayList<Member>(); //List<Member>
	
	/*private List<String> item = null;
	private List<String> path = null;
	private String root;
	private TextView myPath;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPath = (TextView)findViewById(R.id.path); 
        root = Environment.getExternalStorageDirectory().getPath();    
        getDir(root);
    }
	
	private void getDir(String dirPath)
    {
    	myPath.setText("Location: " + dirPath);
    	item = new ArrayList<String>();
	    path = new ArrayList<String>();
	    File f = new File(dirPath);
	    File[] files = f.listFiles();
	     
	    if(!dirPath.equals(root))
	    {
	      item.add(root);
	      path.add(root);
	      item.add("../");
	      path.add(f.getParent()); 
	    }
	     
	    for(int i=0; i < files.length; i++)
	    {
	      File file = files[i];
	      
	      if(!file.isHidden() || file.canRead()) {
	    	  path.add(file.getPath());
	    	  
	          if(file.isDirectory()) {
	            item.add(file.getName() + "/");
	          }
	          else {
	            item.add(file.getName());
	          }
	      } 
	    }

     ArrayAdapter<String> fileList = new ArrayAdapter<String>(this, R.layout.row, item);
     setListAdapter(fileList); 
    }
	
	@Override
	 protected void onListItemClick(ListView l, View v, int position, long id) {
	  // TODO Auto-generated method stub
	  File file = new File(path.get(position));
	  
	  if (file.isDirectory())
	  {
	    if(file.canRead()) {
	      getDir(path.get(position));
	    }
	    else {
	      new AlertDialog.Builder(this)
	       .setIcon(R.drawable.ic_launcher)
	       .setTitle("[" + file.getName() + "] folder can't be read!")
	       .setPositiveButton("OK", null).show(); 
	    } 
	  }
	  else {
	    new AlertDialog.Builder(this)
	      .setIcon(R.drawable.ic_launcher)
	      .setTitle("[" + file.getName() + "]")
	      .setPositiveButton("OK", null).show();

	  }
	 }*/
	
	public static void readFile() { 
		  		
		  String csvFileToRead = "/sdcard/Download/Namensliste.csv";  
		  BufferedReader br = null;  
		  String line = "";  
		  String splitBy = ",";  
		  //setMemberList(new ArrayList<Member>());  
		  
		  try {  
		  
		   br = new BufferedReader(new FileReader(csvFileToRead));  
		   while ((line = br.readLine()) != null) {  
		  
		    // split on comma(',')  
		    String[] members = line.split(splitBy);  
		  
		    // create member object to store values  
		    Member memberObject = new Member();  
		  
		    // add values from csv to member object  
		    memberObject.setLastName(members[0]);  
		    memberObject.setFirstName(members[1]);  
		    memberObject.setBarcode(members[2]);  
		    memberObject.setSelected(false);  
		  
		    // adding member objects to a list
		    memberList.add(memberObject);
		    //getMemberList().add(members[0].toString() + " " + members[1].toString()); 		  
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
		  //return memberList;
		 }  
//Here we have a List of Members

	public static ArrayList<Member> getMemberList() {
		return memberList;
	}

	/*public static void setMemberList(ArrayList<Member> memberList) {
		Read_CSV.memberList = memberList;
	}*/


}
