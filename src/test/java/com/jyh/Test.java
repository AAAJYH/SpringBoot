package com.jyh;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.locks.*;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

    }

    public void conditionWait() {
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
             condition.signal();
        }finally {
            lock.unlock();
        }
    }


}

