package com.jyh.postConstruct;

import com.jyh.base.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author jyh
 * @date 2019/11/25
 * @description
 */

public class PostConstructTest extends BaseTest {

    @Resource
    AAA aaa;

    @Test
    public void a() {
        aaa.a();
    }

}
