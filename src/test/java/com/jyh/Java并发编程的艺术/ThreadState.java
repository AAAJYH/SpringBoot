package com.jyh.Java并发编程的艺术;

import java.util.concurrent.TimeUnit;

/**
 * @author jyh
 * @date 2019/12/14
 * @description
 */

public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }

    //该线程不断进行睡眠
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }


    static class SleepUtils {
        public static final void second (long second) {
            try {
                TimeUnit.SECONDS.sleep(second);
            }catch (Exception e) {}
        }
    }

}
