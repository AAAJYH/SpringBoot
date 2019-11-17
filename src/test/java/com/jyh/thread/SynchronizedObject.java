package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/26
 * @description：
 */

public class SynchronizedObject {

    synchronized public void printString() {
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远supend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }

}
