package com.jyh.数据类型;

import com.jyh.base.BaseTest;
import org.junit.Test;

/**
 * @author jyh
 * @date 2019/12/12
 * @description
 */

public class FloatTest extends BaseTest {

    /**
     * float除以0 等于 Infinity（无限大）
     */
    @Test
    public void a() {
        float f = 2;
        System.out.println(f / 0);
        System.out.println(f * 0);

        System.out.println(Float.POSITIVE_INFINITY * 0);
    }

}
