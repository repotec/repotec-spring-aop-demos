package com.spring.aop;

import com.spring.aop.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.spring.aop")
@EnableAspectJAutoProxy
public class ApplicationConfig {
}
