package com.jyh.Java并发编程的艺术;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jyh
 * @date 2019/12/19
 * @description
 */

public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    @Test
    public void fair() {
        testLock(unfairLock);
    }
    private void testLock(Lock lock) {}

    private static class Job extends Thread {
        private Lock lock;
        public Job(Lock lock) {
            this.lock = lock;
        }
        public void run() {

        }
    }

    private static class ReentrantLock2 extends ReentrantLock {

        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }

    }

}
