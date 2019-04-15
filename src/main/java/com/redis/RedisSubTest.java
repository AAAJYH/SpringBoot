package com.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author: jyh
 * @Date: 2019/4/15 19:48
 */
public class RedisSubTest {

    @Test
    public void sub() {
        System.out.println("订阅者");
        Jedis jedis = null;
        try{
            jedis = new Jedis("127.0.0.1", 6379);

            RedisMsgSubListener sp = new RedisMsgSubListener();
            jedis.subscribe(sp, "new.share", "new.blog");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(jedis == null) {
                jedis.disconnect();
            }
        }
    }

}
