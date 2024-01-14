package com.spring.aop.aspect;

import java.time.Duration;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAfterAdvice {
	
    private final static Logger logger = Logger.getLogger(CustomAfterAdvice.class.getName());

    @After("execution(public * *.getStudentByFirstName(..))")
	public void beforeAnyGetStudent(JoinPoint joinPoint) {
		logger.info("log after getStudentByFirstName method  getStudentByFirstName");
	}


	@After("execution(public * *.delete(..))")
	public void beforeDeleteStudent(JoinPoint joinPoint) {
		logger.info("log after delete method in Student Service");
	}

}