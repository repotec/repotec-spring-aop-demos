package com.spring.aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.aop.model.Student;
import com.spring.aop.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student getStudentByFirstName(String firstName) {
		return studentRepository.getStudentByFirstName(firstName);
	}
	
	public List<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	public void delete(Student student) {
		if(student.getStudentId() == 0) {
			throw new RuntimeException("couldn't found Student to be deleted!");
		}
	}
}
