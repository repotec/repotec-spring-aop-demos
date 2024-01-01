package com.spring.aop.service;

import java.util.List;

import com.spring.aop.annotations.ClassRetAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.aop.model.Student;
import com.spring.aop.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
@ClassRetAnnotation
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;


	public Student getStudentByFirstName(String firstName) {
		return studentRepository.getStudentByFirstName(firstName);
	}
	
	public List<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}
}
