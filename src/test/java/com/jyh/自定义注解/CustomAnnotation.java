package com.jyh.自定义注解;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @ interface CustomAnnotation {

    public int value();

}
