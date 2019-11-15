package com.CoreJava.MainEntryPoint;

import com.CoreJava.DAO.AttendingDAO;
import com.CoreJava.DAO.CourseDAO;
import com.CoreJava.DAO.StudentDAO;
import com.CoreJava.Models.Attending;
import com.CoreJava.Models.Course;
import com.CoreJava.Models.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/*Inside the package named: CoreJava.MainEntryPoint, there is a class named: MainRunner. When your code is complete, 

 * this class will be used to run the School Management System. None of the code in this class should be 
 
 * modified, and it should therefore only be used to test your code after you’ve finalized everything.*/



public class MainRunner {
    public static void main(String[] args) throws IOException {
      try {
    	  System.out.println("Are you a(n)");
          System.out.println("1. Student");
          System.out.println("2. Quit");
          System.out.print("Answer: ");
          Scanner in = new Scanner(System.in);
          int answer = in.nextInt();
          if(answer == 1){
              StudentDAO studentDAO = new StudentDAO();
              List<Student> studentList = studentDAO.getStudents();
              System.out.println("Enter your email: ");
              in.nextLine();
              String email = in.nextLine();
              System.out.println("Enter your password: ");
              String password = in.nextLine();

              if(studentDAO.validateUser(studentList, email, password)){
                  CourseDAO courseDAO = new CourseDAO();
                  AttendingDAO attendingDAO = new AttendingDAO();
                  Student student = studentDAO.getStudentByEmail(studentList, email);
                  List<Course> courseList = courseDAO.getAllCourses();
                  List<Attending> attendingList = attendingDAO.getAttending();

                  myClasses(student, courseList, attendingList);

                  System.out.println("What would you like to do?");
                  System.out.println("1. Register for a new Class");
                  System.out.println("2. Log Out");
                  System.out.print("Answer: ");
                  answer = in.nextInt();

                  if(answer == 1){
                      //Display a list of all Classes
                      allClasses(courseList);
                      System.out.print("Select Course by ID Number: ");
                      int courseID = in.nextInt();
                      System.out.println("Attempting to Register...");
                      attendingDAO.registerStudentToCourse(attendingList, student.getEmail(), courseID);
                      myClasses(student, courseList, attendingList);
                  }

                  System.out.println("Logging Out...");
              }   
              else {
                  System.out.println("Invalid Email or Password.");
              }
          }

          System.out.println("Closing Program. Goodbye.");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
    	
    }

    public static void myClasses(Student student, List<Course> courseList, List<Attending> attendingList) throws FileNotFoundException{
        System.out.println("My Classes: ");
        System.out.printf("%-5s|%-25s|%-25s\n", "#", "COURSE NAME", "INSTRUCTOR NAME");
        AttendingDAO attendingDAO = new AttendingDAO();
        List<Course> courses = attendingDAO.getStudentCourses(courseList, attendingList, student.getEmail());
        for(Course course : courses){
            System.out.printf("%-5s|%-25s|%-25s\n", course.getcid(), course.getCoursename(), course.getInstructor());
        }
    }

    public static void allClasses(List<Course> courseList){
        System.out.println("All Classes: ");
        System.out.printf("%-5s|%-25s|%-25s\n", "#", "COURSE NAME", "INSTRUCTOR NAME");
        for(Course course : courseList){
            System.out.printf("%-5s|%-25s|%-25s\n", course.getcid(), course.getCoursename(), course.getInstructor());
        }
    }
}

