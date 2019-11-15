package com.CoreJava.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.CoreJava.Models.Student;

/*Under the package named: CoreJava.DAO, create a 
 * class and call it StudentDAO. This class is 
 * going to be used to search the CSV files for 
 * student’s information only.*/


public class StudentDAO {
    private List<Student> students=new ArrayList<Student>();;
    
	public List<Student>  getStudents(){
    	File file=new File("C:/Users/perscholas_student/Desktop/Students.csv");
    	Scanner scanner;
		try {
			scanner = new Scanner(file);
	    	while (scanner.hasNextLine()) {
	    		String[] strings =scanner.nextLine().split(",");
	    		students.add(new Student(strings[0],strings[1],strings[2]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e);
		}
		return students;
    }

    public Student getStudentByEmail(List<Student> studentList, String studentEmail){
    	//Student student;
    	for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getEmail().equalsIgnoreCase(studentEmail)) {
				return studentList.get(i);
			}
		}
		return null;

    }

    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getEmail().equalsIgnoreCase(studentEmail) && (studentList.get(i).getPass().equalsIgnoreCase(studentPass))) {
				return true;
			}
		}
    	return false;

    }
}

