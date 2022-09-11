package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomWithinAnnotationPointcut {
	
    private final static Logger logger = Logger.getLogger(CustomWithinAnnotationPointcut.class.getName());

    @AfterReturning(pointcut = "@within(org.springframework.stereotype.Service)")
	public void LogBeforeAnySaveStudent(JoinPoint joinPoint) {
    	
		logger.info("log any method has @Serice annoation " + joinPoint.getSignature().toLongString());
	}
	
}