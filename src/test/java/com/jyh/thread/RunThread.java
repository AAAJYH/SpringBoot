package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/10/8
 * @description：
 */

public class RunThread extends Thread {

    volatile private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void run() {
        System.out.println("进入了 run 了");
        while(isRunning) {

        }
        System.out.println("线程被停止了！");
    }

}
