package com.jyh.java多线程编程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
