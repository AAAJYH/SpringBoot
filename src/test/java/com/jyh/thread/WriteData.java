package com.jyh.thread;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author: jyh
 * @date: 2019/10/15
 * @description：
 */

public class WriteData {

    public void writeMethod(PipedOutputStream out) {
        try{
            System.out.println("write: ");
            for (int i=0; i<300; i++) {
                String outData = "" + (i+1);
                out.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
