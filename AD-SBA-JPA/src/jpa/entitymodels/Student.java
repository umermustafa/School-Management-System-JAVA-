package jpa.entitymodels;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@Column(nullable = false)
	private String email;
	
	@Basic
	@Column(nullable = false)
	private String name;
	
	@Basic
	@Column(nullable = false)
	private String password;

	@OneToMany(targetEntity = Course.class)
	private List<Course> courses;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String email, String name, String password, List<Course> courses) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.courses = courses;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
