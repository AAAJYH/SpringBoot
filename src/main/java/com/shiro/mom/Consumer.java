package com.shiro.mom;

import org.springframework.stereotype.Component;

@Component
public class Consumer {

    /**
     * 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
     * @param txt
     */
//    @JmsListener(destination="mytest.queue")
//    @SendTo("out.queue")
//    public String receiveQueue(String txt){
//        System.out.println("Consumer收到的报文为： "+txt);
//        return txt;
//    }

}
