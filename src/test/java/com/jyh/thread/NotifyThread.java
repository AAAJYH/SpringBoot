package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/10/11
 * @description：
 */

public class NotifyThread extends Thread {

    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized(lock) {
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
        }
    }

}
