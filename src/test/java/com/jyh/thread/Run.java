package com.jyh.thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author: jyh
 * @date: 2019/9/25
 * @description：
 */

public class Run {

    public static void main(String[] args) {
//        try{
//            Object lock = new Object();
//            MyThread a = new MyThread(lock);
//            a.start();
//            MyThread2 b = new MyThread2(lock);
//            b.start();
//            MyThread3 c = new MyThread3(lock);
//            c.start();
//
//            Thread.sleep(1000);
//
//            NotifyThread notifyThread = new NotifyThread(lock);
//            notifyThread.start();
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
        String a = new String();
        MyThread3 m = new MyThread3(a);
        m.start();
        try{
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        m.a();
    }



}
