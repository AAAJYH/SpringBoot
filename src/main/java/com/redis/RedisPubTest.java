package com.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author: jyh
 * @Date: 2019/4/15 19:53
 */
public class RedisPubTest {

    @Test
    public void pub() {
        System.out.println("发布者");
        Jedis jedis = null;
        try {
            jedis = new Jedis("127.0.0.1", 6379);

            jedis.publish("new.share", "新闻分享");
            jedis.publish("new.blog", "新闻博客");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(jedis != null) {
                jedis.disconnect();
            }
        }
    }

}
