package com.jyh.自定义注解;

public class test {

    public static void main(String[] args) {
       User user= UserFactory.create();
        System.out.println(user.getAge());
    }

}
