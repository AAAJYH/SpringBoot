package com.jyh.自定义注解;

import lombok.Data;

@Data
public class User {

    @CustomAnnotation(value=40)
    private int age;

}
