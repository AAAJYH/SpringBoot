package com.jyh.Java并发编程的艺术;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author jyh
 * @date 2019/12/16
 * @description
 */

public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " a " + LocalTime.now());
                        lock.wait();
                    }catch (Exception e) {}
                }
                System.out.println(Thread.currentThread() + " a 完成 "+ LocalTime.now());
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " b " + LocalTime.now());
                lock.notifyAll();
                flag = false;
                ThreadState.SleepUtils.second(5);
            }
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " b 结束" + LocalTime.now());
                ThreadState.SleepUtils.second(5);
            }
        }
    }

}
