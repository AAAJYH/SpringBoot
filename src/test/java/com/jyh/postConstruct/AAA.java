package com.jyh.postConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author jyh
 * @date 2019/11/25
 * @description
 */

@Component
public class AAA {

    @Autowired
    BBB bbb;

    public AAA() {
        System.out.println("此时b还未被注入 b " + bbb);
    }

    /**
     * @PostConstruct：在生成对象时完成某些初始化操作，此注解修饰的方法会在依赖注入完成后被调用，
     */
    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct将在依赖注入完成后被自动调用 b " + bbb);
    }

    public void a() {
        System.out.println("hhh");
    }

}
