package com.jyh;

<<<<<<< HEAD
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

=======
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
>>>>>>> 4ac1b88a956ec2d70137d2c535f905d0c7948f08
import java.io.File;
import java.io.IOException;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test {

<<<<<<< HEAD
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        Runtime runtime = Runtime.getRuntime();
        String path = "D:\\BianCheng\\Idea\\Project\\SpringBoot";
        File file = new File(path);
        if (flag) {

        }

//        runtime.exec("git checkout master",null, file);
//        runtime.exec("git checkout -b a",null, file);
//        runtime.exec("git push origin a",null, file);
//        runtime.exit(0);
=======
    public static void main(String[] args) {

        System.out.println(Test.md5Password("123"));
>>>>>>> 4ac1b88a956ec2d70137d2c535f905d0c7948f08
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

