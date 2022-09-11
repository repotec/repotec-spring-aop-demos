package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomBeforeAdvice {
	
    private final static Logger logger = Logger.getLogger(CustomBeforeAdvice.class.getName());

	@Before("execution(public * *.getStudentByFirstName(..))")
	public void LogBeforeAnyGetStudent() {
		logger.info("log before any method with name getStudentByFirstName");
	}
	
	@Before("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudents() {
		logger.info("log before any method returns List of studens");
	}
	
	@Before("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudentsWithJoinPoint(JoinPoint joinPoint) {
		
		logger.info("log before any method returns List of studens " + joinPoint.getSignature().toString());
	}
	
	@Before("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudents2d(JoinPoint joinPoint) {
		
		logger.info("log before any method returns List of studens " + joinPoint.getSignature().toString());
	}
	
}