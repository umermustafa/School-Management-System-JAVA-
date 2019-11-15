package com.CoreJava.MainEntryPoint;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import com.CoreJava.DAO.StudentDAO;
import com.CoreJava.Models.Student;
import com.CoreJava.DAO.CourseDAO;
import com.CoreJava.Models.Course;
import com.CoreJava.DAO.AttendingDAO;
import com.CoreJava.Models.Attending;
public class TestRunner {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getStudents();
        System.out.format("%-15s  %-15s %-15s","Name","Email","Password");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
        	System.out.format("%-15s  %-15s %-15s\n",studentList.get(i).getName(),studentList.get(i).getEmail(),studentList.get(i).getPass());
		}
       /* Scanner sc=new Scanner(System.in);
        System.out.println("Emter the email address ");
        String email=sc.nextLine();
        String password = null;
        if (studentDAO.getStudentByEmail(studentList, email)!=null) {
			System.out.println(studentDAO.getStudentByEmail(studentList, email).getName());
			password=studentDAO.getStudentByEmail(studentList, email).getPass();
		}
        else {
			System.out.println("Does not exist");
		}
        if (studentDAO.validateUser(studentList, email, password)) {
			System.out.println("Valid User");
		}
        else {
			System.out.println("Not a valid user");
		}*/
        CourseDAO courseDAO=new CourseDAO();
        List<Course> courses=courseDAO.getAllCourses();
       /* System.out.format("%-5s %-15s %-15s", "#","COURSE NAME","INSTRUCTOR NAME");
        System.out.println();
        for (int i = 0; i <courses.size() ; i++) {
			System.out.format("%-5s %-15s %-15s\n", courses.get(i).getcid(),courses.get(i).getCoursename(),courses.get(i).getInstructor());
		}*/
        AttendingDAO attendingDAO=new AttendingDAO();
        List<Attending> attendings=attendingDAO.getAttending();
       /* System.out.format("%-5s %-15s","#","Email");
        System.out.println();
        for (int i = 0; i < attendings.size(); i++) {
			System.out.format("%-5s %-15s\n",attendings.get(i).getcid(),attendings.get(i).getEmail());
		}
        System.out.println("Add new course");
        System.out.println("enter id");
        int id=sc.nextInt();
        System.out.println("enter email");
        String eString=sc.nextLine();
        eString=sc.nextLine();*/
       // attendingDAO.registerStudentToCourse(attendings, eString, id);
        attendings=attendingDAO.getAttending();
      /*  for (int i = 0; i < attendings.size(); i++) {
			System.out.format("%-5s %-15s\n",attendings.get(i).getcid(),attendings.get(i).getEmail());
		}*/
        System.out.println("Courses ids are");
        List<Course> courses2=attendingDAO.getStudentCourses(courses, attendings, "tom@gmail.com");
        for (int i = 0; i < courses2.size(); i++) {
			System.out.println(courses2.get(i).getCoursename()+" "+courses2.get(i).getInstructor());
		}
	}

}
