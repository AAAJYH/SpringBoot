package com.jyh.enumerate;

/**
 * \* Author: 姬雨航
 * \* Date: 2019/7/19 14:00
 * \* Description：枚举类
 *  理解：通过定义枚举值来调用私有的构造方法，来初始化类的属性值，从而实现多种枚举类型，确保枚举类的类型比较安全，属性默认类型public static final；
 * \
 */

public enum CustomEnum {

    /**
     * 枚举值
     * 每一个枚举值都回去调用构造方法去初始化对象属性，相当于每个枚举值都是一个当前类的对象
     */
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    /**
     * 私有构造方法，确保只能内部初始化对象，比较安全
     * @param name
     * @param index
     */
    private CustomEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static void main(String[] args) {

        System.out.println(CustomEnum.RED.name);

    }

}
