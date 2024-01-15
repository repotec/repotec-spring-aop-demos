package com.spring.aop.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.model.Student;

@Component
public interface StudentRepository {
	List<Student> getAllStudent(String name);
	Student getStudentByFirstName(String name);
	void save(Student student);
	Student delete(Student student);
	List<Student> findAllStudents();
}
