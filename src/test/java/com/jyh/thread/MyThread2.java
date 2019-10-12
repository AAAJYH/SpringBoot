package com.jyh.thread;

import java.util.Random;

/**
 * @author: jyh
 * @date: 2019/9/27
 * @description：
 */

public class MyThread2 extends Thread {
    Object b = new Object();


    public void run() {
        try{
            System.out.println("begin");
            b.wait();
            System.out.println("end");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
