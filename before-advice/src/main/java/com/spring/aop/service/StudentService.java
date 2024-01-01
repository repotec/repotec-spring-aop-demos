package com.spring.aop.service;

import java.util.List;
import java.util.logging.Logger;

import com.spring.aop.aspect.AspectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.aop.model.Student;
import com.spring.aop.repository.StudentRepository;

@Service
public class StudentService {

	private final static Logger logger = Logger.getLogger(StudentService.class.getName());

	@Autowired
	private StudentRepository studentRepository;
	
	public Student getStudentByFirstName(String firstName) {
		return studentRepository.getStudentByFirstName(firstName);
	}
	
	public List<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	public void delete(Student student){
		throw new RuntimeException("exception happened");
	}

	public Student update(Student student){
		logger.info("start update student");
		return studentRepository.save(student);
	}
}
