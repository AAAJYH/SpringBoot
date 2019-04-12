package com.shiro.mom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    /**
     *  也可以注入JmsTemplate，JmsMessagingTemplate是对JmsTemplate进行了封装
     */
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送消息，Destination是发送到的队列，message是发送的消息
     * @param destination
     * @param message
     */
//    public void sendMessage(Destination destination, final String message){
//        jmsMessagingTemplate.convertAndSend(destination,message);
//    }
//
//    @JmsListener(destination="out.queue")
//    public void consumerMessage(String text){
//        System.out.println("接收到的报文为："+text);
//    }

}
