package com.jyh.Java并发编程的艺术;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jyh
 * @date 2020/1/8
 * @description
 */

public class AtomicTest {

    static AtomicInteger ai = new AtomicInteger(1);

    @Test
    public void a() {
        System.out.println(ai.incrementAndGet());
        System.out.println(ai.get());
    }

}
