package com.spring.aop.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.model.Student;

@Component
public interface StudentRepository {
	public List<Student> getAllStudent(String name);
	public Student getStudentByFirstName(String name);
	public void save(Student student);
	public Student delete(Student student);
	public List<Student> findAllStudents();
}
