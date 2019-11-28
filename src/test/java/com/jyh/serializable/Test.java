package com.jyh.serializable;

import java.io.*;

/**
 * @author jyh
 * @date 2019/11/13
 * @description
 */

public class Test {

    public static final String path = "C:\\Users\\NING MEI\\Desktop\\user.txt";

    public static void writeObj() {
        User user = new User("1001", "Joe");
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readObj() {
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            Object object = objectInputStream.readObject();
            User user = (User) object;
            System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //writeObj();
        readObj();
    }

}
