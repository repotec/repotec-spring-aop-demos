package com.spring.aop;

import com.spring.aop.model.Student;
import com.spring.aop.service.TeacherService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.service.StudentService;

import java.util.List;

@TestInstance(Lifecycle.PER_CLASS)
public class TargetAnnotationPointcutDesignatorTest {
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
		List<Student> list = studentService.findAllStudents();

		TeacherService teacherService = context.getBean("teacherService", TeacherService.class);
		teacherService.getTeacherByName("test");
    }
}
