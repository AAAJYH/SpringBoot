package com.jyh.customannotation;

import java.lang.reflect.InvocationTargetException;
/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public class Test {

    @SuppressWarnings("AlibabaRemoveCommentedCode")
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        User user= UserFactory.create();
        System.out.println(user.getName());
        System.out.println(user.getAge());

        User user1=new User();
        System.out.println(UserFactory.check(user1));
    }

}
