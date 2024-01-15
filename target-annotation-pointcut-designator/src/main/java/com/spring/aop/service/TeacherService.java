package com.spring.aop.service;

import com.spring.aop.annotations.RuntimeRetAnnotation;
import org.springframework.stereotype.Service;

@Service
@RuntimeRetAnnotation
public class TeacherService {
    public String getTeacherByName(String name){
        return "test";
    }
}
