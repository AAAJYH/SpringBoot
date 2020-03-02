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
     * 方法1：@Qualifier用来声明用哪一个实现类通过byName方式来注入
     * 方法2：属性名为实现类注入的名称也可以
     * @不声明此注解默认会通过byType来注入会抛异常 expected single matching bean but found 2（期望是一个bean但找到了两个）
     */

    @Autowired
    AInterface aInterfaceImpl;

    @Autowired
    @Qualifier("bInterfaceImpl")
    AInterface bInterface;

    @Test
    public void test() {
        System.out.println("11");
        aInterfaceImpl.msg();
        bInterface.msg();
    }


}
