package com.jyh.jdk8.lambda;

import com.jyh.jwt.User;
import com.jyh.反射.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: jyh
 * @date: 2019/10/29
 * @description：
 */

public class StreamTest {

    @Test
    public void a() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter( string -> !string.isEmpty() ).collect(Collectors.toList());


        List<String> list = Arrays.asList("a", "ab", "dr");
        list.stream().forEach(System.out::println);

        list.stream().forEach( a -> System.out.println(a));

        list.forEach(System.out::println);

        list.forEach( a -> System.out.println(a));

    }

    @Test
    public void b() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

//        Random random1 = new Random(10);
//        random.ints().limit(10).forEach(System.out::println);

    }

    @Test
    public void c() {
        List<Integer> list = Arrays.asList(9, 3, 3);
        list = list.stream().distinct().map( i -> i*i).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void d() {
        List<String> list = Arrays.asList("1", "sd");
        list = list.stream().filter( i -> !i.isEmpty() ).collect(Collectors.toList());
    }

    @Test
    public void e() {
        Runnable r = () -> System.out.println("Hello Lambda");
        r.run();

        Consumer<String> con = x -> System.out.println(x);
        con.accept("1");

        Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(1, 2));

        Comparator<Integer> comparator1 = (x,y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        System.out.println(comparator1.compare(1, 2));

    }

    @Data
    @AllArgsConstructor
    public class Student {
        private String name;
        private Integer score;
    }

    @Test
    public void test() {
        List<Student> studentList = new ArrayList<>();
        for (int i=0; i<100; i++) {
            studentList.add(new Student("student"+i, i));
        }

        List<String> studentList1 = studentList.stream()
                .filter(x -> x.getScore() > 50)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(studentList1);
    }

    @Test
    public void test1() {
        Stream<String> stream = Stream.generate(() -> "user").limit(3);
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }

    public boolean filter(Student s) {
        System.out.println("begin compare");
        return s.getScore() > 85;
    }

    @Test
    public void test2() {
        List<Student> studentList = new ArrayList<>();
        for (int i=0; i<100; i++) {
            studentList.add(new Student("student"+i, i));
        }
        Stream<Student> stream = studentList.stream().filter(this::filter);
        System.out.println("split-----------------------------");
        List<Student> studentList1 = stream.collect(Collectors.toList());
        System.out.println(studentList1);
    }

    @Test
    public void test3() {
        List<String> wordList = new ArrayList<String>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        wordList.add("d");
        wordList.add("e");
        wordList.add("f");
        wordList.add("g");

        Stream<String> word = wordList.stream();
        wordList.add("END");
        long n = word.distinct().count();
        System.out.println(n);
    }

    List<String> wordList;
    @Before
    public void init() {
        wordList = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
                add("d");
                add("e");
                add("f");
                add("g");
            }
        };
    }

    @Test
    public void test4() {
        Stream<String> words1 = wordList.stream();
        words1.forEach(s -> {
            System.out.println("s->"+ s);
            wordList.remove(s);
            System.out.println(wordList);
        });
    }

    @Test
    public void testArrayStream() {
        //基本类型
        int[] arr = new int[]{1, 2, 34, 5};
        IntStream intStream = Arrays.stream(arr);

        //引用类型
//        Student[] studentArr = new Student[] {new Student("s1", 29), new Student("s2", 27)};
//        StreamTest
    }

    @Test
    public void testMap() {
        String[] arr = new String[] {"yes", "YES", "no", "NO"};
        Arrays.stream(arr).map(x -> x.toLowerCase()).forEach(System.out::println);
    }

    @Test
    public void testFilter() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).filter( x -> x>3 && x<8 ).forEach(System.out::println);
    }

    @Test
    public void testFlapMap1() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
    }

    String[] arr1 = {"abc", "a", "bc", "abcd"};
    @Test
    public void testSorted() {
        Arrays.stream(arr1).sorted( (x,y) -> {
          if (x.length() > y.length()) {
              return 1;
          }else if (x.length() < y.length()) {
              return -1;
          }else {
              return 0;
          }
        }).forEach(System.out::println);

        Arrays.stream(arr1).sorted((Comparator.comparing(String::length))).forEach(System.out::println);
    }

    @Test
    public void testSorted2() {
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        System.out.println("---------------------------");
        Arrays.stream(arr1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("---------------------------");
        Arrays.stream(arr1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    @Test
    public void initStream() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Stream<String> stringStream = Stream.of("taobao");
        Stream.generate(new Supplier<Double>() {
            public Double get() {
                return Math.random();
            }
        });
        Stream.generate(()->Math.random());
    }

    @Test
    public void test5() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> strings1 = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        strings1.forEach(System.out::println);
        Stream<String> stringStream = Stream.of("a", "b");
        List<String> collect = stringStream.collect(Collectors.toList());
        List<String> names = Stream.of(new Student("jyh", 12), new Student("lpy", 15)).map(student -> student.getName().toUpperCase()).collect(Collectors.toList());
        names.forEach(System.out::println);

        //map对象关系映射
        Stream<String> stringStream1 =  Stream.of("Hello Aron.");
        Stream<String[]> stream = stringStream1.map(word -> word.split(" "));
        stream.forEach(i -> System.out.println(i.toString()));

        //filter过滤筛选
        List<Student> stu = Stream.of(
                new Student("jyh", 19),
                new Student("lisi", 20))
                .filter(student -> student.getScore() > 19)
                .collect(Collectors.toList());
        stu.forEach(System.out::println);

        //max min 最大最小
        Student student = Stream.of(
                new Student("ZhangSan", 19),
                new Student("lisi", 20))
                .min(Comparator.comparing(student1 -> student1.getScore())).get();
        System.out.println(student.toString());

        System.out.println("-----------------------");
        List<Student> studentList = Stream.of(
                new Student("zhangsan", 19),
                new Student("lisi", 20),
                new Student("wangwu", 18))
                .sorted(Comparator.comparing(student1 -> student1.getScore()))
                .collect(Collectors.toList());
        studentList.forEach(System.out::println);
    }

    @Test
    public void test6() {
        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//        System.out.println("sum is: " + nums.stream().filter(num -> num!=null).distinct().mapToInt(num -> num*2).peek(System.out::println).skip(2).limit(4).sum());

        // filter: 对stream中包含的元素使用给定的过滤函数进行操作，新生成的Stream之包含符合条件的元素
        nums.stream().filter(num -> num!=null).forEach(i-> System.out.print(i + " "));
        System.out.println("------------------------");

        // 对Stream中的元素进行去重操作（equals逻辑）
        nums.stream().distinct().forEach(i-> System.out.print(i + " "));
        System.out.println("------------------------");

        // 对Stream包含的元素使用指定的函数，生成的新Stream包含的元素都是Double类型，还有mapToInt、mapToLong
        nums.stream().filter(i -> i!=null).mapToDouble(i -> i).forEach(i-> System.out.print(i + " "));
        System.out.println("------------------------");

        //获取Stream包含元素的前n个元素
        nums.stream().limit(3).forEach(i-> System.out.print(i + " "));
        System.out.println("------------------------");

        //丢弃Stream包含元素的前n个元素
        nums.stream().skip(2).forEach(i -> System.out.print(i + " "));

    }

    //将流中的元素全部放置到一个集合中返回，这里使用Collection，泛指多种集合
    public void toCollectionTest(List<String> list) {
        List<String> ll = list.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(ll);
    }

    //将流中的元素放置到一个列表集合中去，列表默认ArrayList
    public void toListTest(List<String> list) {
        List<String> ll = list.stream().collect(Collectors.toList());
        System.out.println(ll);
    }

    @Test
    public void test7() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "212121", "asda", "3e3e", "2331eew");
        toListTest(list);
    }

    //joining将流中的元素全部以字符序列的方式连接到一起，可以指定字符串，设置是结果的后缀
    @Test
    public void test8() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "212121", "asda", "3e3e", "2331eew");
        //无参方法
        String s = list.stream().collect(Collectors.joining());
        System.out.println(s);
        //指定连接符
        String ss = list.stream().collect(Collectors.joining("-"));
        System.out.println(ss);
        //指定连接符和前后缀
        String sss = list.stream().collect(Collectors.joining("-", "S", "E"));
        System.out.println(sss);
    }

    @Test
    public void test9() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "212121", "asda", "3e3e", "2331eew");

        /**
         * toMap(param1, param2, param3)
         * param1是Key，param2是value，param3是有重复的key进行合并
         */
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(String::length, str ->str, (k1, k2) -> k1));
        System.out.println(map);

        /**
         * 流分组
         */
        Map<Integer, List<String>> map1 = list.stream().collect(Collectors.groupingBy(String::length));

        Map<Integer, List<String>> s = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(s);
        Map<Integer, List<String>> ss = list.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
        System.out.println(ss);
        Map<Integer, List<String>> sss = list.stream().collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.toList()));
        System.out.println(sss);
    }

    @Test
    public void test10() {
        Random random = new Random();
        //创建无限流 无参有返回值的方法
        Stream<Integer> stream = Stream.generate(() -> random.nextInt(100));
        stream.forEach(t -> System.out.println(t));
    }

    @Test
    public void test11() {
        String phone = "13461020531";
        List<User> users = Arrays.asList(new User("fdskf", "13461020531"), new User("fdskf", "13461020531"));
        // 有一个返回true就返回true
        boolean flag1 = users.stream().anyMatch(user -> phone.equals(user.getPhone()));
        // 全部返回true才返回true
        boolean flag2 = users.stream().allMatch(user -> phone.equals(user.getPhone()));
        // 都不为true才返回true
        boolean flag3 = users.stream().noneMatch(user -> phone.equals(user.getPhone()));

        System.out.println(flag1 + "  " + flag2 + "  " + flag3);
    }

}
