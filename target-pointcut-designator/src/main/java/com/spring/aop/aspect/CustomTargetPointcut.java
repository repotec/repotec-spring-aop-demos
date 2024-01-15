package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomTargetPointcut {
    private final static Logger logger = Logger.getLogger(CustomTargetPointcut.class.getName());

	@Before("target(com.spring.aop.repository.StudentRepositoryImpl)")
	public void LogBeforeAllMethodsInInterfaceAnnotatedWithRepositoryUsingTarget() {
		logger.info("[@target] log before the all methods in interface that annotated with @RuntimeRetAnnotation");
	}
}