package com.jyh.数据类型;

import com.jyh.base.BaseTest;
import org.junit.Test;

/**
 * @author jyh
 * @date 2019/12/10
 * @description
 */

public class IntTest extends BaseTest {

    /**
     * 两个正数相乘为什么为会变成负数
     */
    @Test
    public void a() {
        int x = 65535;
        System.out.println(x * x);

        /**
         * X * X = 4294836225
         * int范围 -2147483648 ~ 2147483647
         * 4294836225 - 2147483647 = 2,147,352,578‬
         * int值超出范围会变成最大或最小的int值在计算，变成 -2147483648 + (2,147,352,578‬ - 1) = -131071，-1用来转变int最小值了
         */

    }

}
