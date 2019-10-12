package com.jyh.thread;

import java.util.Random;

/**
 * @author: jyh
 * @date: 2019/9/25
 * @description：
 */

public class MyThread extends Thread {

    private Object lock;

    public MyThread(Object lock) {
        this.lock = lock;
    }

    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }

}
