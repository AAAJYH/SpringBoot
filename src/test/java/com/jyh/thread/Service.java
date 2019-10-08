package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/29
 * @description：
 */

public class Service {

    synchronized public void testMethod1(MyObject object) {
            try{
                System.out.println("testMethod1 getLock time " + System.currentTimeMillis() + " ThreadName " + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("testMethod1 releaseLock time " + System.currentTimeMillis() + " ThreadName" + Thread.currentThread().getName());
            }catch(Exception e) {
                e.printStackTrace();
        }
    }

}
