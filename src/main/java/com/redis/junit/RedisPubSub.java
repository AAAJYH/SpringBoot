package com.redis.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

/**
 * @Author: jyh
 * @Date: 2019/4/15 20:33
 */
public class RedisPubSub extends JedisPubSub {

    private Logger logger = LoggerFactory.getLogger(RedisPubSub.class);

    /**
     *  监听到订阅模式接受到消息时的回调 (onPMessage)
        监听到订阅频道接受到消息时的回调 (onMessage )
        订阅频道时的回调( onSubscribe )
        取消订阅频道时的回调( onUnsubscribe )
        订阅频道模式时的回调 ( onPSubscribe )
        取消订阅模式时的回调( onPUnsubscribe )
     */

    /** 订阅模式接收到消息时的回调 */
    @Override
    public void onMessage(String channel, String message) {
        logger.info("onMessage{"+ "channel："+ channel+ ",message："+ message+ "}");
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        logger.info("onPMessage");
    }

    /**
     * 订阅频道时的回调
     * @param channel 频道名称
     * @param subscribedChannels 订阅频道数量
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        logger.info("onSubscribe { channel : "+ channel+ " , subscribedChannels : "+ subscribedChannels );
    }

}
