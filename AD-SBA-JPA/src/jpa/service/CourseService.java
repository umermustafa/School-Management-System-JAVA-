package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO{

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		EntityManagerFactory managerFactory=Persistence.createEntityManagerFactory("AD-SBA-JPA");
		EntityManager manager=managerFactory.createEntityManager();
		manager.getTransaction().begin();
		Query query=manager.createQuery("select c from Course c");
		List<Course> courses=query.getResultList();
		manager.close();
		managerFactory.close();
		return courses;
	}

}
