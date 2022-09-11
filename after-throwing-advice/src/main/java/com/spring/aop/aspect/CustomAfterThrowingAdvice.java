package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAfterThrowingAdvice {
	
    private final static Logger logger = Logger.getLogger(CustomAfterThrowingAdvice.class.getName());

    @AfterThrowing(pointcut = "execution(public * *.getStudentByFirstName(..))", throwing = "exception")
	public void LogBeforeAnyGetStudent(JoinPoint joinPoint, Exception exception) {
    	logger.info(joinPoint.getSignature().toLongString());
    	exception.printStackTrace();
		logger.info("log after throw exception for any method with name getStudentByFirstName");
	}
	
    @AfterThrowing("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudents() {
		logger.info("log before any method returns List of studens");
	}
	
    @AfterThrowing("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudentsWithJoinPoint(JoinPoint joinPoint) {
		
		logger.info("log before any method returns List of studens " + joinPoint.getSignature().toString());
	}
	
    @AfterThrowing(pointcut =  "execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudentsd2(JoinPoint joinPoint) {
		
		logger.info("log before any method returns List of studens " + joinPoint.getSignature().toString());
	}
	
}