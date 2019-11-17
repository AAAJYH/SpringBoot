package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/10/11
 * @description：
 */

public class Subtract {

    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract(MyList list) {
        try{
            synchronized(lock) {
                if (MyList.size() == 0) {
                    System.out.println("wait begin ThreadName = " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName = " + Thread.currentThread().getName());
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
