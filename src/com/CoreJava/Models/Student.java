package com.CoreJava.Models;

/*Create a class Student with the private member variables specified in TABLE 1. These private members must have GETTERS and SETTERS methods.

The purpose of the Student class is to carry data related to one student.
*/
public class Student {
	private String email,name,pass;
	public Student() {}
	public Student(String em,String nm,String ps){
		setEmail(em);
		setName(nm);
		setPass(ps);
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	public String getEmail() {
		return this.email;
	}
	public String getName() {
		return this.name;
	}
	public String getPass() {
		return this.pass;
	}
}
