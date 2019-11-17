package com.jyh.thread;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author: jyh
 * @date: 2019/10/15
 * @description：
 */

public class ReadData {

    public void readMethod(PipedInputStream input) {
        try{
            System.out.println("read: ");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while(readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.println(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
