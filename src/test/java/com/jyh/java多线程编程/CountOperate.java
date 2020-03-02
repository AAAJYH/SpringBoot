package com.jyh.java多线程编程;

public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("thread getName: " + Thread.currentThread().getName());
        System.out.println("thread isalive: " + Thread.currentThread().isAlive());
        System.out.println("this getName: " + this.getName());
        System.out.println("this isalive: " + this.isAlive());
    }

    @Override
    public void run() {
        System.out.println("thread getName: " + Thread.currentThread().getName());
        System.out.println("thread isalive: " + Thread.currentThread().isAlive());
        System.out.println("this getName: " + this.getName());
        System.out.println("this isalive: " + this.isAlive());
    }

}
