package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomWithinPointcut {
	
    private final static Logger logger = Logger.getLogger(CustomWithinPointcut.class.getName());

	/**
	 *
	 */
	@Before("within(com.spring.aop.service.StudentService)")
	public void LogBeforeAllMethodInServiceStudentClass() {
		logger.info("log before all methods in serviceStudent class");
	}

	/**
	 * //Pointcut to execute on all the methods of classes in a package
	 */
	@Before("within(com.spring.aop.service.*)")
	public void LogBeforeAllMethodsInServicePackage() {
		logger.info("log before the all methods of classes in service package");
	}

	@Before("within(@org.springframework.stereotype.Repository *)")
	public void LogBeforeAllMethodsInInterfaceAnnotatedWithRepository() {
		logger.info("log before the all methods in interface that annotated with @Repository");
	}

	@Before("within(com.spring.aop.repository.StudentRepository +)")
	public void LogBeforeAllMethodsInClassesThatImplementGivenInterface() {
		logger.info("log before the all methods/classes that implements the given interface");
	}
}