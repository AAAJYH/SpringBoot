package com.jyh.lombokTest;

/**
 * @author: jyh
 * @date: 2019/10/29
 * @description：
 */

public class Test {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(16);
        user.setName("jyh");
        user.setId(1);

        User user1 = new User();
        user1.setAge(16);
        user1.setName("jyh");
        user.setId(2);

        System.out.println(user.equals(user1));

    }

}
