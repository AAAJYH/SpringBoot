package com.jyh.thread;

import java.io.PipedOutputStream;

/**
 * @author: jyh
 * @date: 2019/10/15
 * @description：
 */

public class ThreadWrite extends Thread {

    private WriteData  write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        this.write = write;
        this.out = out;
    }

    public void run() {
        write.writeMethod(out);
    }

}
