package com.jyh.thread;

import com.sun.beans.decoder.ValueObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyh
 * @date: 2019/10/11
 * @description：
 */

public class Add {

    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add(MyList list) {
        synchronized(lock) {
            list.add();
            lock.notify();
        }
    }

}
