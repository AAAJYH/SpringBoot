package com.jyh.rabbitmq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置
 * @Author: jyh
 * @Date: 2019/4/1 9:48
 */

@Configuration
public class RabbitMqConfig {

    Logger logger = LoggerFactory.getLogger(RabbitMqConfig.class);

    @Autowired
    private QueueConfig queueConfig;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ExchangeConfig exchangeConfig;

    public static final String ROUTINGKEY_ONE = "routingKeyOne";

    /**
     * 将交换机和队列进行绑定，并设置routingKey
     * @return
     */
    @Bean
    public Binding bindingOne(){
        return BindingBuilder.bind(queueConfig.firstQueue()).
                to(exchangeConfig.directExchange()).with(ROUTINGKEY_ONE);
    }

    /**
     * 注入rabbitTemplate用于数据的接收和发送
     */
    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        /** setConfirmCallback：交换机消息确认设置 */
        rabbitTemplate.setConfirmCallback(new MsgSendConfirmCallBack());
        /**
         * setReturnCallback：交换机路由失败回调设置
         * setMandatory：为true时，exchange根据自身类型和消息routingKey无法找到合适的Queue存储消息，那么会调用return方法将消息发送给生产者
         *               为false时，exchange会直接将消息丢弃
         */
        rabbitTemplate.setReturnCallback(new MsgSendReturnCallback());
        rabbitTemplate.setMandatory(true);
        return rabbitTemplate;
    }

}
