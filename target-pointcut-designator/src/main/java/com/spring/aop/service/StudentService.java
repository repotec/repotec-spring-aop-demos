package com.spring.aop.service;

import java.util.List;

import com.spring.aop.repository.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.aop.model.Student;
import com.spring.aop.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student getStudentByFirstName(String firstName) {
		if(firstName == null)
			throw new RuntimeException("this is an exception");
		
		return studentRepository.getStudentByFirstName(firstName);
	}
	
	public List<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	public void save(Student student){
		studentRepository.save(student);
	}
}
