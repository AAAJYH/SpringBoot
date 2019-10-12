package com.jyh.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyh
 * @date: 2019/9/30
 * @description：
 */

public class MyList {

    private static List<String> list = new ArrayList();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

}
