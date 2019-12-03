package com.jyh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test {

    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-10);
        list.add(30);
        list.add(15);

        list.sort((a, b) -> a - b);

        System.out.println(list);
    }

}

