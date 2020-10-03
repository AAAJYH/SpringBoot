package com.jyh.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jyh
 * @date 2019/11/26
 * @description
 */

public class CGLibMethodInterceptor implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //设置回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事物开始。。。。。。");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("事物结束。。。。。。");
        return result;
    }

    public static void main(String[] args) {
        CGLibMethodInterceptor cgLibMethodInterceptor = new CGLibMethodInterceptor();

        HelloWorldCGLibImpl helloWorldCGLib = (HelloWorldCGLibImpl) cgLibMethodInterceptor.getInstance(new HelloWorldCGLibImpl());

        helloWorldCGLib.showCGLibMsg();
    }

}
