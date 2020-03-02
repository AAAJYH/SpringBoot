package com.jyh.java多线程编程;

public class Run {
    public static void main(String[] args) throws InterruptedException {
       MyThread myThread = new MyThread();
       ThreadA a = new ThreadA(myThread);
       a.start();
       ThreadB b = new ThreadB(myThread);
       b.start();

    }
}
