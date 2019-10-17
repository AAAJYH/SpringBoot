package com.jyh.thread;

import java.util.Random;

/**
 * @author: jyh
 * @date: 2019/9/27
 * @description：
 */

public class MyThread2 extends Thread {

    private C c;

    public MyThread2(C c) {
        this.c = c;
    }

    public void run() {
        while(true) {
            c.popService();
        }
    }

}
