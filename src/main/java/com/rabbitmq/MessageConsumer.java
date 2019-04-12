package com.rabbitmq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @Author: jyh
 * @Date: 2019/4/1 11:05
 *
 */

@Component
public class MessageConsumer {

    Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    /**
     * 队列监听器：监听队列收到新消息进行处理，监听相同的队列，使用轮训模式监听
     * @param message
     */
    @RabbitListener(queues = {"queue-first"})
    public void handleMessageOne(String message){
        logger.info("1处理消息："+ message);
    }

    @RabbitListener(queues = {"queue-first"})
    public void handleMessageTwo(String message){
        logger.info("2处理消息："+ message);
    }

}
