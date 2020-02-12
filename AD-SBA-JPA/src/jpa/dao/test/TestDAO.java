package jpa.dao.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

class TestDAO {

	StudentService studentService;
	@BeforeEach
	void setUp() throws Exception {
		studentService=new StudentService();
	}

	@Test
	void test_getStudent_By_Email() {
		Student expected=new Student();
		expected.setEmail("james");
		expected.setName("Macoy");
		expected.setPassword("123");
		Student actual=studentService.getStudentByEmail("james");
		assertEquals(expected.getEmail(), actual.getEmail());
	}
	
	@Test
	void test_Validate_Student() {
		Student expected=new Student();
		expected.setEmail("james");
		expected.setName("Macoy");
		expected.setPassword("123");
		if (studentService.validateStudent(expected.getEmail(), expected.getPassword())) {
			assertTrue(true);
		}
	}
	
}
