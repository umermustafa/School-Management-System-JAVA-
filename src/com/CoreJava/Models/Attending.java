package com.CoreJava.Models;


/*Create a class Attending with the private member variables specified in TABLE 3. These private members must have GETTERS and SETTERS methods.

The purpose of the Attending class is to carry data related to which Students are attending which Courses.*/



public class Attending {
	private int courseID;
	private String email;
	public Attending() {
		
	}
	public Attending(int cid,String em) {
		setCourseID(cid);
		setEmail(em);
	}
	public void setCourseID(int cid) {
		this.courseID=cid;
	}
	public int getcid() {
		return this.courseID;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return this.email;
	}
}
