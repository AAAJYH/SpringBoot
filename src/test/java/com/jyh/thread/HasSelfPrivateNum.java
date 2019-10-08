package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/29
 * @description：
 */

public class HasSelfPrivateNum {

    private int num = 0;

    synchronized public void addI(String username) {
        String name = username;
        try{
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
