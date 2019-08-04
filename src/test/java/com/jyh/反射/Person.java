package com.jyh.反射;

public class Person {

    String name;
    private int age;

    private void prvt(){
        System.out.println("私有的方法");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
        System.out.println(this.age);
    }

    //包含一个带参德的构造器和一个不带参的构造器
    public Person(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("带参数的构造方法 name:"+name+"  age:"+age);
    }
    public Person(){
        System.out.println("没有参数的构造方法");
    }

}
