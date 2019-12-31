package com.jyh.Java并发编程的艺术;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author jyh
 * @date 2019/12/16
 * @description
 */

public class Piped {

    static class Print implements Runnable {
        private PipedReader in;
        public Print(PipedReader in) {
            this.in = in;
        }
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.println((char) receive);
                }
            }catch (Exception e) {}
        }
    }

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                System.out.println(receive);
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }

}
