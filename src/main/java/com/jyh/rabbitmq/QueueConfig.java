package com.jyh.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置，可以配置多个队列
 * @Author: jyh
 * @Date: 2019/4/1 9:41
 */

@Configuration
public class QueueConfig {

    @Bean
    public Queue firstQueue(){
        /**
         * durable="true" 消息持久化，宕机后未消费的消息，不会删除，默认true
         * auto-delete 表示消息队列没有在使用时将被自动删除,默认是false
         * exclusive 表示该消息队列是否只在当前connection生效，默认false
         */
        return new Queue("queue-first", true, false, false);
    }

}
