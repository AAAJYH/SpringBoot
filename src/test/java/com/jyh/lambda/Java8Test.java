package com.jyh.lambda;

import org.junit.Test;
import org.omg.CORBA.StringHolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: jyh
 * @date: 2019/8/5
 * @description：java8新特性lambda表达式
 */

public class Java8Test {

    List<Employee> emps;
    {
        emps = Arrays.asList(
                new Employee(1, "张三", 18, 9999.99),
                new Employee(2, "李四", 59, 6666.66),
                new Employee(3, "王五", 28, 3333.33),
                new Employee(4, "赵六", 8, 7777.77),
                new Employee(5, "田七", 38, 5555.55)
        );

    }

    public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : emps) {
            if (mp.test(employee)) {
                list.add(employee);
            }
        }
        return list;
    }

    @Test
    public void test1() {

        List<Employee> list = filterEmployee(emps, (e) -> e.getAge() <= 35);
        list.forEach(System.out::println);

    }

    @Test
    public void test2() {
        emps.stream().filter((e) -> e.getAge() <=35)
                .forEach(System.out::println);

        emps.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.out::println);

    }

    @Test
    public void test3() {
        String s  = new String("1") + new String("2");
        System.out.println(s.intern() == s);
    }

}
