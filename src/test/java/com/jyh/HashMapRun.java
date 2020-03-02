package com.jyh;

import java.util.*;

public class HashMapRun {

    public static void main(String[] args) throws InterruptedException {
        List<String> map = new ArrayList<>();
        ThreadA a = new ThreadA(map);
        ThreadB b = new ThreadB(map);
        a.start();
        b.start();
        Iterator i = map.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
