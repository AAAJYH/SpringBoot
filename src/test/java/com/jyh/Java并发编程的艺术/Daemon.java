package com.jyh.Java并发编程的艺术;

import java.util.concurrent.TimeUnit;

/**
 * @author jyh
 * @date 2019/12/14
 * @description
 */

public class Daemon implements Runnable {

    private Thread[] threads = new Thread[10];

    @Override
    public void run() {
        for (int i=0; i< threads.length; i++) {
            threads[i] = new Thread(new DaemonSpawn());
            threads[i].start();
            System.out.println("DaemonSpawn " + i + " started.");
        }

        for (int i=0; i< threads.length; i++) {
            System.out.println("i " + i + " isDaemon" + threads[i].isDaemon());
        }

        while (true) {
            System.out.println("Daemon yield");
            Thread.yield();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true); //必须在启动线程前调用

        d.start();

        System.out.println("d.isDaemon() = " + d.isDaemon() + ".");

//        TimeUnit.SECONDS.sleep(1);
    }

}
