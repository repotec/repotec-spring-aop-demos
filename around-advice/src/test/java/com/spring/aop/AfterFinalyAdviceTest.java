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
public class AfterFinalyAdviceTest {
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
    public void BeforeAdviceAnyGetStudentByFirstName_test() {
		StudentService studentService = context.getBean("studentService", StudentService.class);

		Student student = studentService.getStudentByFirstName("test");
		assertNotNull(student);
    }
	
	@Test
    public void BeforeAdviceAnyLogBeforeAnyArrayOfStudents_test() {
		StudentService studentService = context.getBean("studentService", StudentService.class);

		List<Student> student = studentService.findAllStudens();
		assertNotNull(student);
    }
}
