package com.example.shadow.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public  @interface LogExecutionTime {
    // This is a label explanation, there doesn't need to write any attributes in it!
}