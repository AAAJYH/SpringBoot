package com.jyh.completionStage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/9/3
 */
public class CompletionStageTest {

    public static void main(String[] args) throws InterruptedException {
//        thenCombineAsync();

//        thenApplyAsync();

        acceptEither();

        Thread.sleep(10000);
    }

    /**
     * 两个线程都返回了，才接受
     */
    public static void thenCombineAsync() {
        CompletableFuture<Person> one = CompletableFuture.supplyAsync(new Supplier<Person>() {
            @Override
            public Person get() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Person p = new Person();
                p.setAge(10);
                p.setName("p1");
                return p;
            }
        });

        CompletableFuture<Person> two = CompletableFuture.supplyAsync(new Supplier<Person>() {
            @Override
            public Person get() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Person p = new Person();
                p.setAge(20);
                p.setName("p2");
                return p;
            }
        });

        CompletableFuture<Person> three = one.thenCombineAsync(two, (p1, p2) -> {
            Person p3 = new Person();
            p3.setAge(p1.getAge());
            p3.setName(p2.getName());
            return p3;
        });

        three.thenAcceptAsync((person -> {
            System.out.println(person.getAge());
            System.out.println(person.getName());
        }));
    }

    public static void thenApplyAsync() {
        CompletableFuture<Person> one = CompletableFuture.supplyAsync(new Supplier<Person>() {
            @Override
            public Person get() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Person p = new Person();
                p.setAge(10);
                p.setName("p1");
                return p;
            }
        });

        CompletableFuture<Person> two = one.thenApplyAsync(p1 -> {
            Person p2 = new Person();
            p2.setAge(p1.getAge() + 11);
            p2.setName("p2");
            return p2;
        });

        two.thenAcceptAsync(person -> {
            System.out.println(person.getAge());
            System.out.println(person.getName());
        }).exceptionally(ee -> {
            ee.printStackTrace();
            return null;
        });

    }

    public static void acceptEither() {
        CompletableFuture<Integer> one = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("京东买个锅");
                return 1;
            }
        });

        CompletableFuture<Integer> two = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("淘宝买个锅");
                return 2;
            }
        });


        CompletionStage<Integer> three = one.applyToEither(two, person -> {
            if (person == 1) {
                System.out.println("京东锅到了");
            } else if (person == 2) {
                System.out.println("淘宝锅到了");
            }
            return person;
        });

        CompletionStage<Integer> four = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 洗菜
                System.out.println("菜洗好了");
                return 1;
            }
        });

        four.thenAcceptBothAsync(three, (p1, p2) -> {
            if (p1 ==1 || p1 ==2  && p2 == 1) {
                System.out.println("开始做饭");
            }

        });

    }

}
