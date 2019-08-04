package com.jyh.customannotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 注解解析器：用来解析自定义注解
 */
public class UserFactory {

    /**
     * 解析Init注解
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static User create() throws InvocationTargetException, IllegalAccessException {
        User user = new User();

        //获取User类中所有的方法（getDeclaredMethods也行）
        Method[] methods = User.class.getMethods();

        for (Method method : methods) {
            //如果此方法有注解，就把注解里面的数据复制到user对象
            if (method.isAnnotationPresent(InitAnnotation.class)) {
                //获取指定注解对应的对象
                InitAnnotation init = method.getAnnotation(InitAnnotation.class);
                method.invoke(user, init.value());
            }
        }

        return user;
    }

    public static boolean check(User user){
        if(user==null){
            System.out.println("!!校验对象不能为空！！");
            return false;
        }

        //获取User类的所有属性（如果使用getFields，就无法获取到private属性）
        Field[] fields=User.class.getDeclaredFields();

        for (Field field:fields){
            //如果属性上有注解，就进行校验
            if(field.isAnnotationPresent(ValidateAnnotation.class)){
                //获取属性所对应注解的对象
                ValidateAnnotation validateAnnotation=field.getAnnotation(ValidateAnnotation.class);
                //校验age
                if("age".equals(field.getName())){
                    //是否为空
                    if(user.getAge()==null){
                       System.out.println("年龄校验不通过，年龄不能为空");
                       return false;
                    }else{
                        System.out.println("年龄校验通过");
                    }
                }
            }
        }
        return true;
    }

}
