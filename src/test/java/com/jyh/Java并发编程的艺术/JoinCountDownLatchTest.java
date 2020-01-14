package com.jyh.Java并发编程的艺术;

/**
 * @author jyh
 * @date 2020/1/13
 * @description
 */

public class JoinCountDownLatchTest {

    /**
     * join用于让当前线程等待join线程执行结束，原理是不断地检查join线程是否存活，
     * 如果join线程存活则让当前线程永远等待，wait(0)表示永远等待下去，知道join线程终止后，会调用this.notifyAll()
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 finish");
            }
        });
        thread1.start();
        thread2.start();
//        thread1.join();
        thread2.join();
        System.out.println("all thread finish");
    }

}
