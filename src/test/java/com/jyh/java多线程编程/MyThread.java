package com.jyh.java多线程编程;


import lombok.SneakyThrows;

public class MyThread extends Thread {

    int i;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            System.out.println(i++);
            Thread.sleep(10000);
        }
    }

    public synchronized void a() {
        System.out.println("aaa");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void b() {
        System.out.println("bbb");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void c() {
        System.out.println("ccc");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void d() {
        System.out.println("ddd");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
