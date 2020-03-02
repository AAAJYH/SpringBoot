package com.jyh.Java并发编程的艺术;

import com.jyh.jwt.User;
import org.junit.Test;

import java.util.concurrent.atomic.*;

/**
 * @author jyh
 * @date 2020/1/8
 * @description
 */

public class AtomicTest {

    /**
     * AtomicInteger、AtomicBoolean、AtomicLong：原子更新基本类型
     */
    @Test
    public void a() {
        AtomicInteger ai = new AtomicInteger(1);
        System.out.println(ai.incrementAndGet());
        System.out.println(ai.get());
    }

    /**
     * AtomicIntegerArray、AtomicLongInteger、AtomicReferenceArray：原子更新数组
     * 数组value通过构造方法传进去，然后AtomicIntegerArray会将当前数组复制一份，所以当修改AtomicIntegerArray内部数组时，不会影响传入的数组
     */
    @Test
    public void b() {
        int[] value = new int[]{1, 2};
        AtomicIntegerArray ai =  new AtomicIntegerArray(value);
        ai.getAndSet(0, 3);
        System.out.println(value[0]);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
        AtomicReference atomicReference = new AtomicReference();
    }

    /**
     * AtomicReference：原子更新引用类型
     */
    @Test
    public void c() {
        AtomicReference<User> atomicUserRef = new AtomicReference<>();
        User user = new User("fdsfjsdklj1kl23", "13461020531");
        atomicUserRef.set(user);

        User updateUser = new User("vmsdifjsd", "1514324415");

        atomicUserRef.compareAndSet(user, updateUser);

        System.out.println(atomicUserRef.get().getPhone());
        System.out.println(user.getPhone());
    }

    @Test
    public void d() {
        AtomicIntegerFieldUpdater<Person> a = AtomicIntegerFieldUpdater.newUpdater(Person.class, "old");
        Person conan = new Person("conan", 18);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

    public static class Person {
        private String name;
        public volatile int old;
        public Person(String name, int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;
        }
    }



}
