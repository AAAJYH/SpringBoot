package com.jyh;

import com.jyh.base.BaseTest;
import com.jyh.反射.Person;
import org.springframework.data.redis.core.RedisTemplate;
import sun.nio.cs.ext.MacArabic;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.locks.*;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test extends BaseTest {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    @org.junit.Test
    public void b() {
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 0);

        List a = Collections.singletonList(1);
        System.out.println(a.get(0));
        List list = Arrays.asList(1, 2);

        list.add(1);
        System.out.println("123456".length());
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("name", "jyh");

        List<Person> l = new ArrayList<>();
        Person person = new Person();
        person.setAge(11);
        person.setName("hh");

        l.add(person);

        person.setName("bb");
        person.setAge(55);
        l.add(person);

        System.out.println(l);
        new ArrayList<>(null);
    }

//    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//        System.out.println(8 << 2);
//
//        Map map = new ConcurrentHashMap<String, String>();
//        map.put("1", "jyh");
//        map.put("2", "16");
//        map.put("3", "16");
//        map.put("4", "16");
//        map.put("5", "16");
//        map.put("6", "16");
//        map.put("7", "16");
//        map.put("8", "16");
//        map.put("9", "16");
//        map.put("10", "16");
//        map.put("11", "16");
//        map.put("12", "16");
//        map.put("13", "16");
//        map.put("14", "16");
//        map.put("15", "16");
//        map.put("16", "16");
//        map.put("17", "16");
//
//        map.get("");
//
//        System.out.println(1 << 30);
//        System.out.println(1 << 16);
//
//        System.out.println(1 >>> 1);
//        System.out.println(1 >>> 2);
//        System.out.println(1 >>> 4);
//        System.out.println(1 >>> 8);
//        System.out.println(1 >>> 16);
//
//        int a = 5; // 0000 0101
//        int b = 3; // 0000 0011
//        a |= b; // 0000 00111
//        System.out.println(a);
//    }

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

    @org.junit.Test
    public void a() {
        System.out.println(-1.0 / 0);
        Double a = 1.1;
        System.out.println(a);
        b(a);
        System.out.println(a);
    }
    private void b(Double a) {
        a = 23.01;
    }

}

