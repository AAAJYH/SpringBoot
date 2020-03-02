package com.jyh.数据类型;

import org.junit.Test;

/**
 * @author jyh
 * @date 2019/12/11
 * @description
 */

public class IntegerTest {

    @Test
    public void a() {
        /**
         * 自动拆箱：Java编译器把原始类型自动转换成封装类型的过程称为自动装箱
         * JDK5中对Integer区间-128到127之间做了缓存，Integer缓存策略仅在自动装箱的时候有用，使用构造器创建的Integer对象不能被缓存
         */

        //自动装箱
        java.lang.Integer a = 127;
        java.lang.Integer b = 127;
        System.out.println(a==b);

        //使用构造器
        java.lang.Integer c = new java.lang.Integer(127);
        java.lang.Integer d = new java.lang.Integer(127);
        System.out.println(c == d);

        java.lang.Integer e = 155;
        java.lang.Integer f = 155;
        System.out.println(e == f);

        /**
         * 比较包装类的大小，最好用equals或compareTo（0相等，-1小于，1大于）
         */
        System.out.println(e.equals(f));
        System.out.println(e.compareTo(f));
    }

}
