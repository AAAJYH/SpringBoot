package com.jyh.java多线程编程;

public class ThreadA extends Thread {

    private MyThread myThread;

    public ThreadA(MyThread myThread) {
        this.myThread = myThread;
    }

    @Override
    public void run() {
        myThread.d();
    }
}
