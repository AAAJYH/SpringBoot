package 自定义注解;

import 自定义注解.User;
import 自定义注解.UserFactory;

public class test {

    public static void main(String[] args) {
       User user= UserFactory.create();
        System.out.println(user.getAge());
    }

}
