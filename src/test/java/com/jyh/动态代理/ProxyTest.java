package com.jyh.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * 测试
 */
public class ProxyTest {

    public static void main(String[] args) {

        //创建一个实例对象，这个对象是被代理的对象
        Person  zhangsan=new Student("张三");

        //创建一个与代理对象相关的InvocationHandler
        InvocationHandler stuHandler=new StudentDynamicProxy<Person>(zhangsan);

        //创建一个代理对象stuProxy来代理zhangsan,代理对象的每个执行方法都会替换执行InvocationHandler中的invoke方法
        Person stuProxy=(Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},stuHandler);

        //代理执行上交班费的方法
        stuProxy.giveMoney();

        List a=new ArrayList();
        List b=new Vector();

    }

}
