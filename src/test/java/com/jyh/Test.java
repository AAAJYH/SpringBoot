package com.jyh;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test {

    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String path = "D:\\BianCheng\\Idea\\Project\\SpringBoot";
        runtime.exec("git checkout master",null, new File(path));
        runtime.exec("git checkout -b a",null, new File(path));
        runtime.exec("git push a",null, new File(path));
        runtime.exit(0);
    }

}

