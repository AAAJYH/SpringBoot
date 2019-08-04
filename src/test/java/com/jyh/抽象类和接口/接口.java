package com.jyh.抽象类和接口;

public interface 接口 {

    public int a=1;

    public void a();

    static String b(){
        return "哈哈";
    };

     default String c(){
        return "呵呵";
     };


}
