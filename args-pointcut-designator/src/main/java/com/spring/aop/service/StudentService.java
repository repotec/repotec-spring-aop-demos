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
		if(firstName == null)
			throw new RuntimeException("this is an exception");
		
		return studentRepository.getStudentByFirstName(firstName);
	}

	public Student validateStudentInfo(long studentId, String studentName) {
		if(studentId == 0 && studentName.isEmpty())
			throw new RuntimeException("this is an exception");

		return new Student();
	}
	
	public List<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	public void save(Student student){
		studentRepository.save(student);
	}
}
