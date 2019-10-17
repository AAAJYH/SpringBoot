package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/10/12
 * @description：
 */

public class C {

    private MyStack myStack;

    public C(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop=" + myStack.pop());
    }

}
