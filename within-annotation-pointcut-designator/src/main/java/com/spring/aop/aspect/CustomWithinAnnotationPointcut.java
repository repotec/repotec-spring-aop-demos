package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.time.Duration;
@Aspect
@Component
public class CustomWithinAnnotationPointcut {
	
    private final static Logger logger = Logger.getLogger(CustomWithinAnnotationPointcut.class.getName());

//    @AfterReturning(pointcut = "@within(org.springframework.stereotype.Service)")
//	public void LogBeforeAnySaveStudent(JoinPoint joinPoint) {
//    	
//		logger.info("log any method has @Serice annoation " + joinPoint.getSignature().toLongString());
//	}


    @Around("within(com.spring.aop.service.StudentService)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long finishTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishTime - startTime);
            logger.info(String.format("[Method] %s executes for %s", proceedingJoinPoint.getSignature(), duration));
        }
    }
	
}