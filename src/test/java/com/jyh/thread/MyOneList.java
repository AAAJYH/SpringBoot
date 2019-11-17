package com.jyh.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyh
 * @date: 2019/9/30
 * @description：
 */

public class MyOneList {

    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }

}
