package com.example.rwdmember;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Member extends Fragment {
	
	public static Fragment_Member newInstance(int sectionNumber) {
		Fragment_Member fragment = new Fragment_Member();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
		//Test	
	}
	
	/*private void refresh(ArrayList<Member> newList) {
		memberAdapter = new MemberArrayAdapter(getActivity().getApplicationContext(), newList);
		memberAdapter.notifyDataSetChanged();
	}*/
	
	private ListView listViewMembers;
	private Member[] members;
	private ArrayAdapter<Member> memberAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_member, container, false);
		
		listViewMembers = (ListView) rootView.findViewById(R.id.listViewMember);
		ArrayList<Member> memberlist = Read_CSV.getMemberList();
		memberAdapter = new MemberArrayAdapter(getActivity().getApplicationContext(), memberlist);
		memberAdapter.notifyDataSetChanged();
		listViewMembers.setAdapter(memberAdapter);
	   
	    listViewMembers.setOnItemClickListener(new AdapterView.OnItemClickListener() {  	
	    	@Override
      	    public void onItemClick(AdapterView<?> parent, View view,
      	    						int position, long id) {
	    		Member member = memberAdapter.getItem(position);
	    		member.toggleChecked();
	    		MemberViewHolder viewHolder = (MemberViewHolder) view.getTag();
	    		viewHolder.getCheckBox().setChecked(member.isSelected());
	    		Toast.makeText(getActivity().getApplicationContext(),
      	          "Member Number: " + member.getBarcode(), Toast.LENGTH_SHORT)
      	          .show();
      	    }
      	});
	    
	    return rootView;
	}
	
	private static class MemberViewHolder {
	    private CheckBox checkBox;
	    private TextView textView;
	    
	    public MemberViewHolder() {}
	    public MemberViewHolder(TextView textView, CheckBox checkBox) {
	      this.checkBox = checkBox;
	      this.textView = textView;
	    }
	    
	    public CheckBox getCheckBox() {
	      return checkBox;
	    }
	    public void setCheckBox(CheckBox checkBox) {
	      this.checkBox = checkBox;
	    }
	    public TextView getTextView() {
	      return textView;
	    }
	    public void setTextView(TextView textView) {
	      this.textView = textView;
	    }    
	  }
	
	  private static class MemberArrayAdapter extends ArrayAdapter<Member> {
	    
	    private LayoutInflater inflater;
	    
	    public MemberArrayAdapter(Context context, List<Member> memberList) {
	      super(context, R.layout.simplerow, R.id.rowTextView, memberList);
	      inflater = LayoutInflater.from(context) ;
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	      Member member = (Member) this.getItem(position); 

	      CheckBox checkBox; 
	      TextView textView; 
	      
	      if (convertView == null) {
	        convertView = inflater.inflate(R.layout.simplerow, null);

	        textView = (TextView) convertView.findViewById(R.id.rowTextView);
	        checkBox = (CheckBox) convertView.findViewById(R.id.CheckBox01);
	        
	        convertView.setTag(new MemberViewHolder(textView,checkBox));

	        checkBox.setOnClickListener(new View.OnClickListener() {
	          public void onClick(View v) {
	            CheckBox cb = (CheckBox) v ;
	            Member member = (Member) cb.getTag();
	            member.setSelected(cb.isChecked());;
	          }
	        });        
	      }
	      else {
	        MemberViewHolder viewHolder = (MemberViewHolder) convertView.getTag();
	        checkBox = viewHolder.getCheckBox() ;
	        textView = viewHolder.getTextView() ;
	      }

	      checkBox.setTag(member); 
	      
	      checkBox.setChecked(member.isSelected());
	      textView.setText(member.getLastName() + " " + member.getFirstName());      
	      
	      return convertView;
	    }
	  }
}
	
