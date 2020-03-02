package com.jyh.thread;

import com.jyh.base.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jyh
 * @date 2020/1/3
 * @description
 */

public class ConcurrentHashMapTest extends BaseTest {

    @Test
    public void a() {
        HashMap<String, String> map = new HashMap<>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int j = 0; j < 10; j++) {
                                map.put(UUID.randomUUID().toString() + j + "", "");
                            }
                            System.out.println(Thread.currentThread().getName());
                        }
                    }).start();
                }
            }
        });
        t.start();
    }

    @Test
    public void b() {
        Map map = new ConcurrentHashMap(15);
    }

}
