package com.jyh.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: jyh
 * @date: 2019/10/9
 * @description：
 */

public class MyService {

    public  AtomicLong aiRef = new AtomicLong();

    synchronized public void addNum() {
        System.out.println(Thread.currentThread().getName() + "加了100之后的值是：" + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }



}
