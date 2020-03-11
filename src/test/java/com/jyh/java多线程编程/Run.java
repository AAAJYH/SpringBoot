package com.jyh.java多线程编程;

public class Run {
    public static void main(String[] args) throws InterruptedException {
       Thread a = new YouThread("A");
        Thread b = new YouThread("B");
        Thread c = new YouThread("C");
        b.start();
        c.start();
        a.start();

    }
}
