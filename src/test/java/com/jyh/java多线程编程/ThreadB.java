package com.jyh.java多线程编程;

public class ThreadB extends Thread {

    private MyThread myThread;

    public ThreadB (MyThread myThread) {
        this.myThread = myThread;
    }

    @Override
    public void run() {
        myThread.b();
    }
}
