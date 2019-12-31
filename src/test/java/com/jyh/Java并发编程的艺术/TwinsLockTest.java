package com.jyh.Java并发编程的艺术;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @author jyh
 * @date 2019/12/19
 * @description
 */

public class TwinsLockTest {

    @Test
    public void test() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        ThreadState.SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        ThreadState.SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i=0; i<10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i=0; i<10; i++) {
            ThreadState.SleepUtils.second(1);
            System.out.println();
        }

    }

}
