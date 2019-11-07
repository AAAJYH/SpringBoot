package com.jyh.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jyh
 * @date: 2019/8/8
 * @description：
 */

@Data
@AllArgsConstructor
public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;


}
