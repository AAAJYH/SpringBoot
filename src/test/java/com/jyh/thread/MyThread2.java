package com.jyh.thread;

import java.util.Random;

/**
 * @author: jyh
 * @date: 2019/9/27
 * @description：
 */

public class MyThread2 extends Thread {

    private Service service;
    private MyObject myObject;

    public MyThread2(Service service, MyObject myObject) {
        this.service = service;
        this.myObject = myObject;
    }

    public void run() {
        myObject.speedPrintString();
    }

}
