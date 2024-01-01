package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
	
    private final static Logger logger = Logger.getLogger(AspectConfig.class.getName());

	@Before("execution(* com.app.service.*.*(..))")
	public void LogBeforeAnyGetStudent() {
		logger.info("log before any method in service classes");
	}

	@Before("execution(void com.spring.aop.service.StudentService.delete(..))")
	public void LogBeforeDeleteStudents() {
		logger.info("log before StudentService.delete method");
	}

	@Before("execution(* com.spring.aop.service.StudentService.update(..))")
	public void LogBeforeUpdateStudent() {
		logger.info("log before StudentService.update method");
		throw new RuntimeException("exception");
	}
	
//	@Before("execution(java.util.List<com.spring.aop.model.Student>) *.*())")
//	public void LogBeforeAnyArrayOfStudentsWithJoinPoint(JoinPoint joinPoint) {
//		logger.info("log before any method returns List of students " + joinPoint.getSignature().toString());
//	}
//
//	@Before("execution(java.util.List<com.spring.aop.model.Student>) *.*())")
//	public void LogBeforeAnyArrayOfStudents2d(JoinPoint joinPoint) {
//		logger.info("log before any method returns List of students " + joinPoint.getSignature().toString());
//	}
}