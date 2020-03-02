package com.jyh.反射机制;

import java.lang.reflect.Method;

public class DumpMethods {

    public static void main(String[] args) throws ClassNotFoundException {
        //加载并初始化命令行参数指定的类
        Class classType = Class.forName(args[0]);
        Method methods[] = classType.getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
    }

}
