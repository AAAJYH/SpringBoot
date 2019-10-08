package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/29
 * @description：
 */

public class Main {

    public int i = 10;
    synchronized public void operateIMainMethod() {
        try{
            i--;
            System.out.println("main print i= " + i);
            Thread.sleep(100);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
