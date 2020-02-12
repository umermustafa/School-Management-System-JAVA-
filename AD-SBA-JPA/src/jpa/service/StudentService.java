package jpa.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO{

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("AD-SBA-JPA");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Query query=manager.createQuery("select s from Student s");
		List<Student> students=query.getResultList();
		manager.close();
		factory.close();
		return students;
	}

	@Override
	public Student getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("AD-SBA-JPA");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Student student=manager.find(Student.class, email);
		manager.close();
		factory.close();
		return student;
	}

	@Override
	public boolean validateStudent(String email, String password) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("AD-SBA-JPA");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Student> query=manager.createQuery("select s from Student s where s.email= :email and s.password= :password",Student.class); 
		query.setParameter("email", email).setParameter("password", password);
		Student student=query.getSingleResult();
		manager.close();
		factory.close();
		if (student==null) {
			return false;
		}
		return true;
	}

	@Override
	public void registerStudentToCourse(String email, int cid) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("AD-SBA-JPA");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Student student=manager.find(Student.class, email);
		Course course=manager.find(Course.class,cid);
		for (Course c : student.getCourses()) {
			if (c.getId()==cid) {
				System.out.println("You are already taking this course");
				manager.close();
				factory.close();
				return;
			}
		}
		student.getCourses().add(course);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("AD-SBA-JPA");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Student student=manager.find(Student.class, email);
		List<Course> courses=student.getCourses();
		manager.close();
		factory.close();
		return courses;
	}

}
