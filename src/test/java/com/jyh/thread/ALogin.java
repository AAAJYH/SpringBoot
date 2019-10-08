package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/25
 * @description：
 */

public class ALogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }

}
