package com.CoreJava.Models;

/*Create a class Course with the private member variables specified in TABLE 2. These private members must have GETTERS and SETTERS methods.

The purpose of the Course class is to carry data related to one Course.
*/

public class Course {
	private int courseID;
	private String courseName;
	private String instructor;
	public Course() {
		
	}
	public Course(int id,String cname,String ins) {
		setCourseID(id);
		setCourseName(cname);
		setInstructor(ins);
	}
	public void setCourseID(int cid) {
		this.courseID=cid;
	}
	public void setCourseName(String name) {
		this.courseName=name;
	}
	public void setInstructor(String instructor) {
		this.instructor=instructor;
	}
	public int getcid() {
		return this.courseID;
	}
	public String getCoursename() {
		return this.courseName;
	}
	public String getInstructor() {
		return this.instructor;
	}
}
