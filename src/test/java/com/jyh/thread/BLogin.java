package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/25
 * @description：
 */

public class BLogin extends Thread {

    public void run() {
        LoginServlet.doPost("b", "bb");
    }

}
