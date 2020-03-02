package com.jyh.java多线程编程;

public class Test {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getId() + " " + thread.getName());
    }

}
