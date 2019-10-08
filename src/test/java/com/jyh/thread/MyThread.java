package com.jyh.thread;

import java.util.Random;

/**
 * @author: jyh
 * @date: 2019/9/25
 * @description：
 */

public class MyThread extends Thread {

    private Service service;
    private MyObject myObject;

    public MyThread(Service service, MyObject myObject) {
        this.service = service;
        this.myObject = myObject;
    }

    public void run() {
        service.testMethod1(myObject);
    }

}
