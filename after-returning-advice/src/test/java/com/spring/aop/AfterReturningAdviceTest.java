package com.spring.aop;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.model.Student;
import com.spring.aop.service.StudentService;

@TestInstance(Lifecycle.PER_CLASS)
public class AfterReturningAdviceTest {
	AnnotationConfigApplicationContext context = null;
	
	@BeforeAll
    public void init() {
		context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }
	
	@AfterAll
    public void destroy() {
		if(context != null)
			context.close();
    }
	
	@Test
    public void beforeAdviceAnyGetStudentByFirstName_test() {
		StudentService studentService = context.getBean("studentService", StudentService.class);

		Student student = studentService.getStudentByFirstName("ahmed");
		assertNotNull(student);
    }

	@Test
	public void beforeAdviceWithExceptionAnyGetStudentByFirstName_test() {
		StudentService studentService = context.getBean("studentService", StudentService.class);

		Student student = studentService.getStudentByFirstName(null);
		assertNotNull(student);
	}
	
	@Test
    public void beforeAdviceAnyLogBeforeAnyArrayOfStudents_test() {
		StudentService studentService = context.getBean("studentService", StudentService.class);

		List<Student> student = studentService.findAllStudents();
		assertNotNull(student);
    }
}