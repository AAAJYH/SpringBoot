package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/29
 * @description：
 */

public class Service {

    public void testMethod(Object lock) {
        try{
            synchronized(lock) {
                System.out.println("begin wait() ThreadName = " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait() ThreadName = " + Thread.currentThread().getName());
            }
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("出现异常了，因为wait状态的线程被interrupt了");
        }
    }

    public void synNotifyMethod(Object lock) {
        try{
            synchronized(lock) {
                System.out.println("begin notify() ThreadName " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("end notify() ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
