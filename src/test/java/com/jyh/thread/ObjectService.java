package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/30
 * @description：
 */

public class ObjectService {

    public void serviceMethod() {
        try {
            synchronized(this) {
                System.out.println("begin time " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time " + System.currentTimeMillis());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
