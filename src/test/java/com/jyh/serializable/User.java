package com.jyh.serializable;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * @author jyh
 * @date 2019/11/11
 * @description：在进行io操作或者通络通信要在网络中传送对象时要实现serializable，把对象转换成字节序列变成一长串的字节（byte）
 */

@AllArgsConstructor
public class User implements Serializable {

    /**
     * serialVersionUID对序列化类的一个标识，在反序列化的时候通过serialVersionUID来确定哪个类来加载这个对象
     * 当然如果写jvm会默认生成一个serialVersionUID，这样就会导致其于编译器耦合，最好现实的声明serialVersionUID
     */
    private static final long serialVersionUID = 5936476746653719866L;

    private String userId;

    private String userName;

}
