package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 *
 * @Author: jyh
 * @Date: 2019/4/1 10:11
 *
 */

public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    Logger logger = LoggerFactory.getLogger(MsgSendConfirmCallBack.class);

    /**
     * 消息发送到交换机确认事件
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info("--------------------消息发送到交换机确认事件----------------------");
        logger.info("消息唯一标识correlationData："+ correlationData);
        logger.info("确认字符ack："+ ack);
        logger.info("失败原因cause："+ cause );
    }
}
