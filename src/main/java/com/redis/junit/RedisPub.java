package com.redis.junit;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @Author: jyh
 * @Date: 2019/4/15 20:43
 */

public class RedisPub {

    private Logger logger = LoggerFactory.getLogger(RedisPub.class);

    @Test
    public void pub() {
        logger.info("------发布者------");
        Jedis jedis = null;
        try{
            jedis = new Jedis("127.0.0.1", 6379);
            jedis.publish("channelOne", "你好啊");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(jedis != null) {
                jedis.disconnect();
            }
        }
    }

}
