package com.jyh.jdk8.optional;

import com.jyh.jdk8.lambda.StreamTest;

import java.util.Optional;

/**
 * @author jyh
 * @date 2019/12/4
 * @description
 */

public class OptionalTest {

    public static void main(String[] args) {

        /**
         * 三种构造
         * of：必须设置value的 静态方法
         * empty()：空value的静态方法
         * ofNullable：可为空value的静态方法
         */
        Optional<String> optionalStr1 = Optional.of("123");
        Optional<String> optionalStr2 = Optional.empty();
        Optional<String> optionalStr3 = Optional.ofNullable(null);

        // get()：获取value值，为空会报错
        String a = optionalStr1.get();
        System.out.println(a);

        // filter(Predicate<? super T> predicate)：对Optional对象进行过滤，返回符合predicate条件的数据
        // orElse(T other)：如果对象value值为空，就返回other的值
        String b = Optional.ofNullable("123").filter(s -> !s.equals("123")).orElse("空");
        System.out.println(a);

        //map(Function<? super T, ? extends U> mapper)：通过map函数式参数运算后返回新的Optional<T>对象
        int c = Optional.of("123").map(s -> s.length()).get();
        System.out.println(c);

    }

}
