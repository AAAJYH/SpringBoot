package com.jyh.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 */
public class StudentDynamicProxy<T> implements InvocationHandler{

    //代理对象
    T target;

    public StudentDynamicProxy(T target){
        this.target=target;
    }

    /**
     *
     * @param proxy 表示代理对象
     * @param method 表示正在执行的方法
     * @param args 表示调用方法时传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行"+method.getName()+"方法");
        Object rs=method.invoke(target,args);
        return rs;
    }
}
