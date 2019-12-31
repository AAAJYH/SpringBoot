package com.jyh.Java并发编程的艺术;

import java.util.concurrent.TimeUnit;

/**
 * @author jyh
 * @date 2019/12/16
 * @description
 */

public class Shutdown {

     private static class Runner implements Runnable {

         private long i;
         private volatile boolean on = true;

         @Override
         public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
             }
             System.out.println("Count i = "+ i);
         }

         public void cancel() {
             on = false;
         }
     }

    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        //睡眠1秒，main线程对CountThread进行中断，是CountThread能够感知而结束
        TimeUnit.SECONDS.sleep(1 );
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        //线程1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而 结束
        two.cancel();

    }

}
