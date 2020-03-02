package com.jyh.Java并发编程的艺术;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author jyh
 * @date 2019/12/14
 * @description
 */

public class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("1");
        try {
            Thread.sleep(1000);
            System.out.println("2");
            File f = new File("D:\\BianCheng\\Idea\\Project\\SpringBoot\\src\\test\\java\\com\\jyh\\a.txt");
            FileOutputStream os = new FileOutputStream(f, true);
            os.write("daemon".getBytes());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable tr = new TestRunnable();
        Thread thread = new Thread(tr);
        thread.setDaemon(true);
        thread.start();
    }

}
