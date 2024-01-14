package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomArgsAnnotationPointcut {
	
    private final static Logger logger = Logger.getLogger(CustomArgsAnnotationPointcut.class.getName());

    @Before("@args(org.springframework.stereotype.Component)")
    public void beforeAnyMethodsAcceptingComponentAnnotation(JoinPoint joinPoint){
        logger.info("Accepting beans with @Component annotation: " +
                joinPoint.getArgs()[0] + "|methodName:" + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
    }
}