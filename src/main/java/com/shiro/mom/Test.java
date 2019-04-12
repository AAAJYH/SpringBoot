package com.shiro.mom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {

    @Autowired
    private Producer producer;

//    public void contextLoads() {
//        Destination destination=new ActiveMQQueue("mytest.queue");
//        for(int i=0;i<10;i++){
//            producer.sendMessage(destination,"MyNameIsJYH");
//        }
//    }


}
