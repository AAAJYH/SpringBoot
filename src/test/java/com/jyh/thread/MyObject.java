package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/29
 * @description：
 */

public class MyObject {

   synchronized public void speedPrintString() {
       System.out.println("speedPrintString ___ getLock time =  " + System.currentTimeMillis() + "run ThreadName = " + Thread.currentThread().getName());
       System.out.println("-----------------------");
       System.out.println("speedPrintString releaseLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread().getName());
   }

}
