package com.example.rwdmember;

public class Member {
  
 private String firstName = null;
 private String lastName = null;
 private String Barcode = null;
 private boolean selected = false;
 
 public Member() {}
  
 public Member(String firstName, String lastName, String Code, boolean selected) {
  super();
  this.firstName = firstName;
  this.lastName = lastName;
  this.Barcode = Code;
  this.selected = selected;
 }  
 
 public String getFirstName() {
  return firstName;
 }
 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }
 public String getLastName() {
  return lastName;
 }
 public void setLastName(String lastName) {
  this.lastName = lastName;
 }
 
 public String getBarcode() {
	  return Barcode;
 }
 public void setBarcode(String Barcode) {
  this.Barcode = Barcode;
 }
 
 public boolean isSelected() {
  return selected;
 }
 public void setSelected(boolean select) {
  this.selected = select;
 }
 public void toggleChecked() {  
	 selected = !selected ;  
   } 
}