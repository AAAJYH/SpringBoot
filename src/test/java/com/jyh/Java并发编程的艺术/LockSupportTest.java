package com.jyh.Java并发编程的艺术;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

/**
 * @author jyh
 * @date 2019/12/21
 * @description
 */

/**
 * LockSupport工具类提供了一组静态方法，用来阻塞和唤醒线程
 */

public class LockSupportTest {

    /**
     * LockSupport.part()：阻塞当前线程
     */
    @Test
    public void a() {
        System.out.println("开始 --- 阻塞当前线程");
        LockSupport.park();
        // 唤醒线程
        // LockSupport.unpark(new Thread());
        System.out.println("1111111111111");
    }

    /**
     * LockSupport.parkNanos：阻塞当前线程指定纳秒后环形线程
     */
    @Test
    public void b() {
        System.out.println("开始 --- 阻塞当前线程1,000,000,000纳秒（1秒）");
        LockSupport.parkNanos(1000000000);
        System.out.println("--- 阻塞结束");
    }

    /**
     * LockSupport.parkUntil：阻塞当前线程到指定时间（毫秒）
     *
     */
    @Test
    public void c() {
        System.out.println("--- 阻塞当前线程2000毫秒（2秒）");
        LockSupport.parkUntil(System.currentTimeMillis() + 2000);
        System.out.println("--- 阻塞结束");
    }

}
