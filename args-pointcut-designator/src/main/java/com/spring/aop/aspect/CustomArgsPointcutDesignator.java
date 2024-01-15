package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomArgsPointcutDesignator {
    private final static Logger logger = Logger.getLogger(CustomArgsPointcutDesignator.class.getName());

    @Pointcut("args(long, String)")
    public void studentValidation(){

    }

    /**
     * before advice to execute and match any Methods accept an object (as parameter) that annotated with @Component
     */
    @Before("args(long, String) && args(studentId, studentName)")
    public void beforeAnyMethodsAcceptStdIdAndStdNameAsParameter(long studentId, String studentName){
        logger.info( studentId + " " +studentName);
    }
}