package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/10/11
 * @description：
 */

public class MyThread3 extends Thread {

    private String lock;

    public MyThread3(String lock) {
        this.lock = lock;
    }

    public void run() {
        try{
            synchronized(lock) {
                System.out.println("begin");
                lock.wait();
                System.out.println("end");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

   public void a() {
       synchronized (lock) {
            lock.notify();
       }
   }

}
