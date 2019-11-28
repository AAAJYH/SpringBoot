package com.jyh;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.io.IOException;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test {

    public static void main(String[] args) {

        System.out.println(Test.md5Password("123"));
    }

    public static String md5Password(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

            return "";
        }}
//        String a = "123";
//        String b = "123 ";
//        String c = null;
//        String d = " ";
//        String e = "";
//
//        System.out.println(StringUtils.isBlank(a));
//        System.out.println(StringUtils.isBlank(b));
//        System.out.println(StringUtils.isBlank(c));
//        System.out.println(StringUtils.isBlank(d));
//        System.out.println(StringUtils.isBlank(e));

        //比大小的时候一边为空会报空指针异常

}

