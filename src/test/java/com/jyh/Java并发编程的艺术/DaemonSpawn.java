package com.jyh.Java并发编程的艺术;

/**
 * @author jyh
 * @date 2019/12/14
 * @description
 */

public class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("DaemonSpawn yield");
            ThreadState.SleepUtils.second(1);
            Thread.yield();
        }
    }

}
