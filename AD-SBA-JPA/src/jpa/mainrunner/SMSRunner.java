package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	static Scanner scanner=new Scanner(System.in);
	static StudentService studentService=new StudentService();
	static CourseService courseService=new CourseService();
	
	public static void selectCourse(String email) {
		System.out.println("Which Course");
		String courseNumber=scanner.next();
		switch (courseNumber) {
		case "1":
			studentService.registerStudentToCourse(email, 1);
			break;
		case "2":
			studentService.registerStudentToCourse(email, 2);
			break;
		case "3":
			studentService.registerStudentToCourse(email, 3);
			break;
		case "4":
			studentService.registerStudentToCourse(email, 4);
			break;
		case "5":
			studentService.registerStudentToCourse(email, 5);
			break;
		case "6":
			studentService.registerStudentToCourse(email, 6);
			break;
		case "7":
			studentService.registerStudentToCourse(email, 7);
			break;
		case "8":
			studentService.registerStudentToCourse(email, 8);
			break;
		case "9":
			studentService.registerStudentToCourse(email, 9);
			break;
		case "10":
			studentService.registerStudentToCourse(email, 10);
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}	
	
	public static void showStudentCourses(String email) {
		System.out.println("My Classes");
		List<Course> courses=studentService.getStudentCourses(email);
		System.out.printf("%-5s|%-30s|%s\n", "#", "COURSE NAME", "INSTRUCTOR NAME");
		for (Course course : courses)
		{
			System.out.printf("%-5s|%-30s|%s\n", course.getId(), course.getName(), course.getInstructor());		
		}
	}
	
	public static  void showAllCourses() {
		List<Course> courses2=courseService.getAllCourses();

		System.out.printf("%-5s|%-30s|%s\n", "#", "COURSE NAME", "INSTRUCTOR NAME");

		System.out.println();
		for (Course course : courses2) 
		{
			System.out.printf("%-5s|%-30s|%s\n", course.getId(), course.getName(), course.getInstructor());				
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Are you a student");
		System.out.println("1.Student");
		System.out.println("2.quit");
		String input=scanner.next();
		if (input.equals("1"))
		{
			System.out.println("Enter your email");
			scanner.nextLine();
			String email=scanner.nextLine();
			System.out.println("Enter your password");
			String password=scanner.nextLine();
			if (studentService.validateStudent(email, password)) 
			{
				showStudentCourses(email);
			}
			System.out.println();
			String input2="";
			do {
				System.out.println("1.Register to class");
				System.out.println("2.Logout");
				input2=scanner.next();
				if (input2.equals("1")) 
				{
					showAllCourses();
					selectCourse(email);
					showStudentCourses(email);
					
					
				}
				else if (input2.equals("2"))
				{
					System.out.println("Signed Out");
					System.exit(0);
				}
				else {
					System.out.println("Wrong input,Enter Again");
				}
			} while (!input2.equals("2"));
			

		}
		else if (input.equals("2")) 
		{
			return;
		}
	}

}
