package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/26
 * @description：
 */

public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("begin");
        System.out.println("Thread.currentThread().getName() "+ Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()" + Thread.currentThread().isAlive());
        System.out.println("this.getName()" + this.getName());
        System.out.println("this.isAlive()" + this.isAlive());
        System.out.println("end");
    }

    public void run() {
        System.out.println("run begin ");
        System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() " + Thread.currentThread().isAlive());
        System.out.println("this.getName() " + this.getName());
        System.out.println("this.isAlive() " + this.isAlive());
        System.out.println("run end");
    }

}
