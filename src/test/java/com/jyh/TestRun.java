package com.jyh;

import com.jyh.反射.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jyh
 * @date 2019/4/10
 */

public class TestRun {

    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        person.setName("1");
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(list.stream().filter(l -> l > 5).findAny().orElse(null));
    }

}
