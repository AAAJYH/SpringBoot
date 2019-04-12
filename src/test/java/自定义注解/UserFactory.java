package 自定义注解;

import 自定义注解.CustomAnnotation;
import 自定义注解.User;

import java.lang.reflect.Field;

public class UserFactory {

    public static User create(){
        User user=new User();
        Field[] fields=user.getClass().getDeclaredFields();
        for (Field f:fields){
            if (f.isAnnotationPresent(CustomAnnotation.class)){
                CustomAnnotation customAnnotation=f.getAnnotation(CustomAnnotation.class);
                user.setAge(customAnnotation.value());
            }
        }
        return user;
    }


}
