package com.jyh.lombokTest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.thymeleaf.util.Validate;

/**
 * @author: jyh
 * @date: 2019/10/29
 * @description：
 */

public class User extends People {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
