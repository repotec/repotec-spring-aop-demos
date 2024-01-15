package com.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomThisPointcutDesignator {
    private final static Logger logger = Logger.getLogger(CustomThisPointcutDesignator.class.getName());

    /**
     * before advice to execute and match any bean reference of StudentRepository interface.
     * StudentRepositoryImpl bean reference is not the actual object that implements StudentRepository interface, but a proxy object that
     * wraps the original object and adds some additional functionality
     */
    @Before("this(com.spring.aop.repository.StudentRepository)")
    public void beforeStudentRepositoryBeanReference(JoinPoint joinPoint){
        logger.info("Object:" + joinPoint.getThis());
        logger.info("class:" + joinPoint.getThis().getClass().getName());
    }
}