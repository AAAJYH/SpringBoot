package com.jyh;

import java.util.List;
import java.util.Map;

public class ThreadB extends Thread {

    private List map;

    public ThreadB(List m) {
        this.map = m;
    }

    @Override
    public void run() {
        map.add("age");
    }
}
