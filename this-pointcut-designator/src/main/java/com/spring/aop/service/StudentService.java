package com.spring.aop.service;

import com.spring.aop.model.Student;
import com.spring.aop.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
