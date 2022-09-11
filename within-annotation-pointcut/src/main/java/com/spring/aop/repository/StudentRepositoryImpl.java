package com.spring.aop.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.aop.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	
	@Autowired
	Student student;
	
	@Override
	public List<Student> getAllStudent(String name) {
		return null;
	}

	@Override
	public Student getStudentByFirstName(String name) {
		return new Student(1, "Ahmed", "mohammed", 30);
	}

	@Override
	public void save(Student student) {
	}

	@Override
	public Student delete(Student student) {
		return null;
	}

	@Override
	public List<Student> findAllStudents() {
		return Arrays.asList(new Student(1, "Ahmed", "mohammed", 30));
	}
}
