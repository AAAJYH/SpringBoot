package com.jyh.Java并发编程的艺术;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * @author jyh
 * @date 2019/12/17
 * @description
 */

public class Join {

    static class Domino implements Runnable {
        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }
        public void run() {
            try {
                thread.join();
            }catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + "terminate.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i=0; i<10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
//            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + "terminate.");
    }

}
