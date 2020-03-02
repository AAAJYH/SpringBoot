package com.jyh;

import java.util.List;
import java.util.Map;

public class ThreadA extends Thread {

    private List map;

    public ThreadA(List m) {
        this.map = m;
    }

    @Override
    public void run() {
        map.add("name");
    }

}
