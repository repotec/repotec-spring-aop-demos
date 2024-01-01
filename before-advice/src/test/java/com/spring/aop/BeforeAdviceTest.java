package com.spring.aop;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.logging.Logger;

import com.spring.aop.aspect.AspectConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.model.Student;
import com.spring.aop.service.StudentService;

@TestInstance(Lifecycle.PER_CLASS)
public class BeforeAdviceTest {
	private final static Logger logger = Logger.getLogger(BeforeAdviceTest.class.getName());
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

		List<Student> student = studentService.findAllStudents();
		assertNotNull(student);
    }

	@Test
	public void beforeAdviceWithExceptions() {
		logger.info("before exception in delete method");
		StudentService studentService = context.getBean("studentService", StudentService.class);
		studentService.delete(new Student());
		logger.info("after exception in delete method");
	}

	@Test
	public void beforeAdviceWithExceptionsInsideAdvice() {
		StudentService studentService = context.getBean("studentService", StudentService.class);
		Student any = studentService.update(new Student());
	}
}
