package com.jyh;

import Idea.A;
import com.jyh.反射.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

/**
 * @author jyh
 * @date 2019/4/10
 */

public class TestRun {

    public static void main(String[] args) throws InterruptedException {

        Optional<String> a = Optional.of("a");
        String get = a.get();

        Optional<String> b = Optional.empty();

        Optional<String> c = Optional.ofNullable(null);

        // 是否存在
        boolean cIs = c.isPresent();

        String bGet = b.orElse("b");

        String cc = b.orElseGet(()->"c");

        Set<Integer> number = new HashSet<>(Arrays.asList(1, 2, 3, 5));

        Set<Integer> sameOrder = number.stream().collect(Collectors.toCollection(TreeSet::new));

        Assert.assertEquals(number, sameOrder);

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l2 = Arrays.asList(1, 2, 3);
        List<Integer> l3 = Arrays.asList(1);
        List<List<Integer>> l = Arrays.asList(l1, l2, l3);
        Double avg = l.stream().collect(Collectors.averagingInt(i -> i.size()));

        String s = l.stream().map(i -> i.stream().map(j->j.toString()).collect(Collectors.joining(","))).collect(Collectors.joining(",", "[", "]"));

        List<Integer> l4 = Arrays.asList(1, 1, 2, 3, 4, 5, 5, 5);
        Map<Integer, List<Integer>> map = l4.stream().collect(Collectors.groupingBy(i -> i));
        Map<Integer, Long> mapCount = l4.stream().collect(Collectors.groupingBy(i -> Integer.parseInt(i.toString()), counting()));

        List<Integer> l5 = Arrays.asList(1, 2, 3, 4, 5);
        StringBuilder stringBuilder = new StringBuilder("[");

        Assert.assertTrue(true);
    }

    public String a() {
        return "a";
    }

    public interface IntegerBiFunction extends BinaryOperator<Integer> {

    }

    public void overLoadMethod(BinaryOperator<Integer> lambda){
        System.out.println("lambda");
    }

    public void overLoadMethod(String integerBiFunction){
        System.out.println("lambda");
    }

}
