package com.jyh.proxy.jdk;

/**
 * @author jyh
 * @date 2019/11/27
 * @description
 */

public class RealSubject implements Subject, a {


    @Override
    public void doSomething() {
        System.out.println("RealSubject do something");
    }

    @Override
    public void b() {
        System.out.println("G");
    }
}
