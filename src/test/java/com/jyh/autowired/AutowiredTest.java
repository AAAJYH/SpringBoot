package com.jyh.autowired;

import com.jyh.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author jyh
 * @date 2019/12/1
 * @description
 */

public class AutowiredTest extends BaseTest {

    /**
     * @Qualifier用来声明用哪一个实现类通过byName方式来注入
     * @不声明此注解默认会通过byType来注入会抛异常 expected single matching bean but found 2（期望是一个bean但找到了两个）
     */

    @Autowired
    @Qualifier(value = "aInterfaceImpl")
    AInterface aInterface;

    @Autowired
    @Qualifier("bInterfaceImpl")
    AInterface bInterface;

    @Test
    public void test() {
        System.out.println("11");
        aInterface.msg();
        bInterface.msg();
    }


}
