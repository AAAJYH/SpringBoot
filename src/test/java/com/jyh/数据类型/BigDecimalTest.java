package com.jyh.数据类型;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author jyh
 * @date 2019/12/11
 * @description
 */

public class BigDecimalTest {

    @Test
    public void a() {
        BigDecimal bigDecimal = BigDecimal.ONE;
        System.out.println(bigDecimal);

        BigDecimal bigDecimal1 = BigDecimal.TEN;

        // add: 加
        bigDecimal.add(bigDecimal);
        // subtract: 减
        bigDecimal.subtract(bigDecimal);
        // multiply: 乘
        bigDecimal.multiply(bigDecimal);
        // divide: 除
        System.out.println(bigDecimal.divide(bigDecimal1));;

    }

}
