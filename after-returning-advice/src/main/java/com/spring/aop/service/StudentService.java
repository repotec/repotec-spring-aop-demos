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
			throw new RuntimeException("firstName cannot be null!");
		
		return studentRepository.getStudentByFirstName(firstName);
	}

	public List<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	public void deleteStudent(Student student){
		studentRepository.delete(student);
	}
}
