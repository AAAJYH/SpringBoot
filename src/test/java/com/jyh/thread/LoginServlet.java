package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/9/25
 * @description：
 */

public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {

        try{
            usernameRef = username;
            if(username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username: " + usernameRef + "password: "+ passwordRef);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
