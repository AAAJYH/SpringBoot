package com.jyh.thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author: jyh
 * @date: 2019/9/25
 * @description：
 */

public class Run {

    public static void main(String[] args) {
        try{
            MyObject myObject = new MyObject();
            Service service = new Service();
            MyThread m1 = new MyThread(service, myObject);
            m1.setName("a");
            m1.start();
            MyThread2 m2 = new MyThread2(service, myObject);
            m2.setName("b");
            m2.start();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
