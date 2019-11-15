package com.CoreJava.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.CoreJava.Models.Attending;
import com.CoreJava.Models.Course;;

/*Under the package named: CoreJava.DAO, create a 
 * class and call it AttendingDAO. This class is 
 * going to be used to query the database for 
 * Attending’s information.*/



public class AttendingDAO {
	public List<Attending> getAttending() throws FileNotFoundException{
		File file=new File("C:/Users/perscholas_student/Desktop/attending.csv");
		Scanner scanner=new Scanner(file);
		List<Attending> list=new ArrayList<Attending>();
		while (scanner.hasNextLine()) {
			String[] strings=scanner.nextLine().split(",");
			list.add(new Attending(Integer.parseInt(strings[0]), strings[1]));
		}
		return list;

    }

    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID) throws IOException{
    	File file=new File("C:/Users/perscholas_student/Desktop/attending.csv");
    	Scanner scanner=new Scanner(file);
    	boolean flag=false;
    	for (int i = 0; i < attending.size(); i++) {
			if (attending.get(i).getEmail().equalsIgnoreCase(studentEmail) && attending.get(i).getcid()==courseID) {
				flag=true;
				break;
			}
		}
    	if (flag) {
			System.out.println("Student is already taking that course");
		}
    	else {
			Attending newCourse=new Attending(courseID, studentEmail);
			attending.add(newCourse);
			saveAttending(attending);
		}
    	
    }

    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){
		
    	List<Course> studentCourses=new ArrayList<>();
    	for (int i = 0; i < courseList.size(); i++) {
			for (int j = 0; j < attending.size(); j++) {
				if (courseList.get(i).getcid()==attending.get(j).getcid() && attending.get(j).getEmail().equalsIgnoreCase(studentEmail)) {
					studentCourses.add(courseList.get(i));
				}
			}
		}
    	
    	return studentCourses;
    }

    public void saveAttending(List<Attending> attending){
    	for (Attending attending2 : attending) {
			System.out.println(attending2.getcid());
		}
    	String loc="C:/Users/perscholas_student/Desktop/attending.csv";
		File file=new File(loc);
		try {
			FileWriter fw=new FileWriter(file,false);
			for (Attending attending2 : attending) {
				//fw.write(String.format("%s,%s\n",attending2.getcid(),attending2.getEmail()));
				fw.write(String.format("%s,%s\n",attending2.getcid(),attending2.getEmail()));
			}
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
