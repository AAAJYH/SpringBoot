    package com.jyh.rabbitmq;

    import org.springframework.amqp.rabbit.core.RabbitTemplate;
    import org.springframework.amqp.rabbit.support.CorrelationData;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;
    import java.util.UUID;

    /**
     * 消息发送 生产者
     * @Author: jyh
     * @Date: 2019/4/1 10:59
     */

    @Component
    public class SendMessage {

        @Autowired
        private RabbitTemplate rabbitTemplate;

        /**
         *  将消息路由到交换机绑定的队列
         *  CorrelationData 消息的关联id
         * @param message 消息内容
         */
        public void send(Object message){
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            rabbitTemplate.convertAndSend("exchangeTest", "routingKeyOne" , message, correlationData);
        }

    }
