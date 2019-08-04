package com.jyh.rabbitmq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息交换机配置，可以配置多个
 * @Author: jyh
 * @Date: 2019/4/1 9:37
 */

@Configuration
public class ExchangeConfig {

     /** 消息交换机的名字 */
    public static final String DIRECT_EXCHANGE_NAME = "exchangeTest";

    /**
     * 1.定义direct exchange，绑定queueTest
     * 2.durable="true" rabbit重启的时候不需要创建新的交换机，默认true
     * 3.autoDelete交换机在没有使用的时候自动被删除
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        DirectExchange directExchange = new DirectExchange(DIRECT_EXCHANGE_NAME, true, false);
        return directExchange;
    }

}
