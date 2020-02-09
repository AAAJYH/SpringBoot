package com.jyh.线程池;

public class Operation implements Runnable {

    @Override
    public void run() {
        System.out.println("操作");
    }

}
