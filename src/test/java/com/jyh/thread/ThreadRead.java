package com.jyh.thread;

import java.io.PipedInputStream;

/**
 * @author: jyh
 * @date: 2019/10/15
 * @description：
 */

public class ThreadRead extends Thread {

    private ReadData read;

    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }

    public void run() {
        read.readMethod(input);
    }

}
