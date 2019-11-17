package com.jyh.thread;

import java.util.Random;

/**
 * @author: jyh
 * @date: 2019/9/25
 * @description：
 */

public class MyThread extends Thread {

    private P p;

    public MyThread(P p) {
        this.p = p;
    }

    public void run() {
        while(true) {
            p.pushService();
        }
    }

}
