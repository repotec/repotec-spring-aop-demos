package com.spring.aop.repository;

import com.spring.aop.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
	List<Student> getAllStudent(String name);
	Student getStudentByFirstName(String name);
	void save(Student student);
	Student delete(Student student);
	List<Student> findAllStudents();
}
