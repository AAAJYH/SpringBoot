package com.jyh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.json.JSONString;

import java.util.*;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test {

    public static void main(String[] args) {

        Float f1 = new Float(-1.0f/0.0);
        Float f2 = new Float(0.0/0.0);
        Float f3 = 0.0f/0.0f;
        System.out.println(f1+ " = " + f1.isNaN());
        System.out.println(f2+ " = " + f2.isNaN());
        System.out.println(f3+ " = " + f3.isNaN());

    }

}

