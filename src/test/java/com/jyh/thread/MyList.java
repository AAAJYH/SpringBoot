package com.jyh.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyh
 * @date: 2019/9/30
 * @description：
 */

public class MyList {

    private List list = new ArrayList();
    synchronized public void add(String username) {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " 执行了add方法");
        list.add(username);
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " 推出了add方法");
    }

    synchronized public int getSize() {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " 执行了getSize方法");
        int sizeValue = list.size();
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " 退出了getSize方法");
        return sizeValue;
    }

}
