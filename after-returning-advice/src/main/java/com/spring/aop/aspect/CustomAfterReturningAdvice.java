package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAfterReturningAdvice {
	
    private final static Logger logger = Logger.getLogger(CustomAfterReturningAdvice.class.getName());

    /**
     * with void nothing will happen
     * @param joinPoint
     * @param returnValue
     */
    @AfterReturning(pointcut = "execution(public !void *.save(..))", returning = "returnValue")
	public void LogBeforeAnySaveStudent(JoinPoint joinPoint, Object returnValue) {
    	logger.info(returnValue.toString());
		logger.info("log after throw exception for any method with name getStudentByFirstName");
	}
	
    @AfterReturning(pointcut = "execution(java.util.List<com.spring.aop.model.Student> *.*())", returning = "returnValue")
	public void LogAfterReturningAnyArrayOfStudents(Object returnValue) {
    	logger.info(returnValue.toString());
		logger.info("log before any method returns List of studens");
	}

	/**
	 * AfterReturning without joinPoint
	 * @param returnValue
	 */
    @AfterReturning(pointcut = "execution(java.util.List<com.spring.aop.model.Student> *.*())", returning = "returnValue")
	public void LogAfterReturningAnyArrayOfStudentsd2(Object returnValue) {
    	logger.info(returnValue.toString());
		logger.info("log before any method returns List of students ");
	}

	/**
	 * AfterReturning with joinPoint and returned value
	 * @param returnValue
	 */
	@AfterReturning(pointcut = "execution(java.util.List<com.spring.aop.model.Student> *.*())", returning = "returnValue")
	public void LogAfterReturningAnyArrayOfStudentsWithJoinPoint(JoinPoint joinPoint, Object returnValue) {
		logger.info(returnValue.toString());
		logger.info("log before any method returns List of students " + joinPoint.getSignature().toString());
	}

	@AfterReturning(pointcut = "execution(java.util.List<com.spring.aop.model.Student> *.*())", returning = "returnValue")
	public void LogAfterReturningAnyArrayOfStudentsWithJoinPoint(Object returnValue) {
		logger.info(returnValue.toString());
		logger.info("log after returning | any method returns List of students | list should named as students ");
	}
	
}