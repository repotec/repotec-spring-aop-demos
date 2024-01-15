package com.spring.aop.repository;

import com.spring.aop.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentRepositoryImpl implements StudentRepository {
	
	@Autowired
	Student student;

	public List<Student> getAllStudent(String name) {
		return null;
	}

	public Student getStudentByFirstName(String name) {
		return new Student(1, "Ahmed", "mohammed", 30);
	}

	public void save(Student student) {
	}

	public Student delete(Student student) {
		return null;
	}

	public List<Student> findAllStudents() {
		return Arrays.asList(new Student(1, "Ahmed", "mohammed", 30));
	}
}
