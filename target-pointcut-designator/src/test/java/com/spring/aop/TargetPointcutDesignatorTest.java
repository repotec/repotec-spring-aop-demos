package com.spring.aop;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.model.Student;
import com.spring.aop.service.StudentService;

@TestInstance(Lifecycle.PER_CLASS)
public class TargetPointcutDesignatorTest {
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
    public void BeforeAdviceAnyLogBeforeAnyArrayOfStudents_test() {
		StudentService studentService = context.getBean("studentService", StudentService.class);
		studentService.save(new Student(1,"test", "test", 20));
    }
}
