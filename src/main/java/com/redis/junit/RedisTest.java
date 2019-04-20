package com.redis.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Author: jyh
 * @Date: 2019/4/15 15:57
 */
public class RedisTest {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(RedisTest.class);
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        logger.info("jedis.ping()："+ jedis.ping());

        /** 设置String字符串 */
        jedis.set("name", "张三");
        jedis.set("age", "20");
        jedis.get("name");
        logger.info("jedis.get(\"name\")："+ jedis.get("name"));

        /** 设置List集合 */
        jedis.lpush("list", "aaa");
        jedis.lpush("list", "bbb");
        jedis.lpush("list","ccc");
        List<String> list = jedis.lrange("list", 0 , 2);
        for (String str : list) {
            logger.info("list："+ str);
        }

        /** 设置Set集合 */
        jedis.sadd("set", "ddd");
        jedis.sadd("set", "eee");
        jedis.sadd("set", "fff");

        Set<String> set = jedis.smembers("set");
        for (String str: set) {
            logger.info("set："+ str);
        }

        Map<String,String> map = new HashMap<String,String>();
        map.put("put1", "val1");
        map.put("put2", "val2");
        jedis.hmset("map", map);
        Map<String, String> redisMap = jedis.hgetAll("map");
        for (String str : redisMap.keySet()) {
            logger.info("map { key："+ str+ ", value："+ redisMap.get(str)+ "}");
        }

        /** 获取所有key */
        Set<String> allKey = jedis.keys("*");
        Iterator<String> iterator = allKey.iterator();
        while(iterator.hasNext()) {
            logger.info("allKey："+iterator.next());
        }

    }

}
