package com.jyh.thread;

/**
 * @author: jyh
 * @date: 2019/10/12
 * @description：
 */

public class P {

   private MyStack myStack;

   public P(MyStack myStack) {
       this.myStack = myStack;
   }

   public void pushService() {
       myStack.push();
   }

}
