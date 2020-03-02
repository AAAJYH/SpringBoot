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
         * 4294836225 转二进制为 11111111111111100000000000000001
         * 11111111111111100000000000000001 从右取 32（int32为）11111111111111100000000000000001
         * 11111111111111100000000000000001 从右开始第一个1倒序为 0000000000000000111111111111111
         * 0000000000000000111111111111111 再转为10进制 32767
         */

    }

}
