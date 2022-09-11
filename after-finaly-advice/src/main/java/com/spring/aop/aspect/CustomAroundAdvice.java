package com.spring.aop.aspect;

import java.time.Duration;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAroundAdvice {
	
    private final static Logger logger = Logger.getLogger(CustomAroundAdvice.class.getName());

    @Around("execution(public * *.getStudentByFirstName(..))")
	public void executeAroundAnyGetStudent(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("log before any method with name getStudentByFirstName");
		try {
			joinPoint.proceed();
		}finally {
			//Do Something useful
			logger.info("log after any method with name getStudentByFirstName");
		}
		
	}
	
    @Around("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudents(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("log before any method returns List of studens");
		
		try {
			joinPoint.proceed();
		}finally {
			//Do Something useful
			logger.info("log after any method with name getStudentByFirstName");
		}
	}
	
    @Around("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudentsWithJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
    	long startTime = System.currentTimeMillis();
    	
		logger.info("log before any method returns List of studens " + joinPoint.getSignature().toString());
		
		try {
			joinPoint.proceed();
		}finally {
			//Do Something useful
			
			long finishTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishTime - startTime);
            logger.info(String.format("Method %s executes for %s", joinPoint.getSignature(), duration));
		}
	}
	
    @Around("execution(java.util.List<com.spring.aop.model.Student> *.*())")
	public void LogBeforeAnyArrayOfStudentsd2(ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.info("log before any method returns List of studens " + joinPoint.getSignature().toString());
		
		try {
			joinPoint.proceed();
		}finally {
			//Do Something useful
			logger.info("log after any method with name getStudentByFirstName");
		}
	}
	
}