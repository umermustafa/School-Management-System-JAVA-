package jpa.entitymodels;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@Column(nullable = false)
	private int id;
	
	@Basic
	@Column(nullable = false)
	private String name;
	
	@Basic
	@Column(nullable = false)
	private String instructor;

	
	public Course() {
		super();
	}

	public Course(int id, String name, String instructor) {
		super();
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
}
