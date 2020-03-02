package com.jyh.Java并发编程的艺术;

import com.jyh.base.BaseTest;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jyh
 * @date 2020/1/13
 * @description
 */

public class CyclicBarrierTest extends BaseTest {

    /**
     * CyclicBarrier同步屏障，让一组线程达到一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程达到屏障时，屏障才会开门，所有被拦截的线程才会继续运行
     * CyclicBarrier默认构造方法CyclicBarrier(int parties)，表示屏障拦截的线程数，每个线程调用await()方法，parties就会减1，当等于0时被拦截的线程继续运行
     * CyclicBarrier更高级的构造方法CyclicBarrier(int parties, Runnable barrierAction)，当屏障阻塞线程数达到parties数量时，优先去执行barrierAction的run()方法
     * CyclicBarrier可用于多线程计算数据，最后合并结果的场景
     */
    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    static CyclicBarrier c2 = new CyclicBarrier(2, new A());
    @Test
    public void a() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    c2.await();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            c2.await();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);

    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }

    /**
     * CyclicBarrier的isBroken()方法用来判断阻塞的线程是否被中断
     */
    static CyclicBarrier c3 = new CyclicBarrier(2);
    @Test
    public void b() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c3.await();
                    System.out.println("c3 await 1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(c3.isBroken());
        c3.reset();
        thread.interrupt();
        Thread.sleep(1000);
        try {
            c3.await();
            System.out.println("c3 await 2");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(c3.isBroken());
        }
    }

}
