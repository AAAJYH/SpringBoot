package com.jyh.Java并发编程的艺术;

import java.util.concurrent.CountDownLatch;

/**
 * @author jyh
 * @date 2020/1/13
 * @description CountDownLatch
 */

public class CountDownLatchTest {

    /**
     * CountDownLatch用于等待多线程完成后主线程再往下执行（join也可以实现）
     * CountDownLatch构造方法接受一个int类型的参数作为计数器
     * 调用countDown方法时，计数器就会减1，CountDownLatch的await方法会阻塞当前线程，知道计数器的值变成0
     * 有的线程跑的比较慢，不可能让主线程一直等待，可以使用await(long time, TimeUnit unit)待指定时间的await方法，到点就不再阻塞当前线程
     */
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }

}
