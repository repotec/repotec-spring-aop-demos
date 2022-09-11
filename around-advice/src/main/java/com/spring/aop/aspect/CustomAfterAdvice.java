package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAfterAdvice {
	
    private final static Logger logger = Logger.getLogger(CustomAfterAdvice.class.getName());

    @After("execution(public * *.getStudentByFirstName(..))")
	public void LogBeforeAnyGetStudent() {
		logger.info("log before any method with name getStudentByFirstName");
	}
	
    @After("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudents() {
		logger.info("log before any method returns List of studens");
	}
	
    @After("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudentsWithJoinPoint(JoinPoint joinPoint) {
		
		logger.info("log before any method returns List of studens " + joinPoint.getSignature().toString());
	}
	
    @After("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudentsd2(JoinPoint joinPoint) {
		
		logger.info("log before any method returns List of studens " + joinPoint.getSignature().toString());
	}
	
}