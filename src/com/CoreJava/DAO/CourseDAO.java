package com.CoreJava.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.CoreJava.Models.Course;

/*Under the package named: CoreJava.DAO, create a 
 * class and call it CourseDAO. This class is 
 * going to be used to query the database for the 
 * course’s information only.*/


public class CourseDAO {
	public List<Course> getAllCourses() throws FileNotFoundException{
		List<Course> courses=new ArrayList<Course>();
		File file=new File("C:/Users/perscholas_student/Desktop/courses.csv");
		Scanner sc=new Scanner(file);
		while (sc.hasNextLine()) {
			String[] strings=sc.nextLine().split(",");
			courses.add(new Course(Integer.parseInt(strings[0]),strings[1],strings[2]));
		}
		return courses;

    }

}
