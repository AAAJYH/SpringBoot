//package com.redis.junit;
//
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import redis.clients.jedis.Jedis;
//
///**
// * @Author: jyh
// * @Date: 2019/4/15 20:40
// */
//public class RedisSubTest {
//
//    private Logger logger = LoggerFactory.getLogger(RedisPubTest.class);
//
//    @Test
//    public void sub() {
//        logger.info("------订阅者------");
//        Jedis jedis = null;
//        try {
//            jedis = new Jedis("127.0.0.1", 6379);
//            RedisPubSub redisPubSub = new RedisPubSub();
//            jedis.subscribe(redisPubSub, "channelOne", "channelTwo");
//        } catch(Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(jedis != null) {
//                jedis.disconnect();
//            }
//        }
//    }
//
//}
