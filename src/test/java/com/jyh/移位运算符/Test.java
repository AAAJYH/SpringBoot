package com.jyh.移位运算符;

import com.jyh.base.BaseTest;

/**
 * @author jyh
 * @date 2019/12/20
 * @description
 */

/**
 *
 * >> ：右移（从最右边开始移除二进制位数），正数高位补0，负数高位补1
 * >>> : 无符号右移即逻辑右移，正数高位补0，负数高位也补0
 * << : 左移 低位补0，不区正负
 */

public class Test extends BaseTest {

    @org.junit.Test
    public void a() {
        int i = 2;
        System.out.println(i << 2);
        System.out.println(-i << 2);
    }

}
