package com.jyh.java多线程编程;

public class YouThread extends Thread{

    String name;

    public YouThread(String name) throws InterruptedException {
        this.name = name;
        this.setName(name);
//        if ("A".equals(name)) {
//            System.out.println("sleep " + Thread.currentThread().getName());
//            Thread.sleep(5000);
//        }
    }

    @Override
    public void run() {
        if ("A".equals(name)) {
            System.out.println("sleep " + Thread.currentThread().getName());
            try {
                this.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName());
    }
}
