package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Author: jyh
 * @Date: 2019/4/8 18:32
 */

public class MsgSendReturnCallback implements RabbitTemplate.ReturnCallback{

    Logger logger = LoggerFactory.getLogger(MsgSendConfirmCallBack.class);

    /**
     * 交换机路由队列失败时回调事方法
     * @param message
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("--------------------交换机路由队列失败时回调方法----------------------");
        System.out.println("消息主体Message："+ message);
        System.out.println("回复码relpyCode："+ replyCode);
        System.out.println("回复内容replyText："+ replyText);
        System.out.println("交换机exchange："+ exchange);
        System.out.println("routingKey："+ routingKey);
    }
}
