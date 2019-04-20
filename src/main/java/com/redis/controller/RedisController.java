package com.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: jyh
 * @Date: 2019/4/17 11:07
 */

@RestController
public class RedisController {

    Logger logger = LoggerFactory.getLogger(RedisController.class);

    /**
         redisTemplate.opsForValue();//操作字符串
         redisTemplate.opsForHash();//操作hash
         redisTemplate.opsForList();//操作list
         redisTemplate.opsForSet();//操作set
         redisTemplate.opsForZSet();//操作有序set
     */

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public String redisTest() {
        try{

            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();

            /** 设置过期时间，单位分钟 */
            redisTemplate.opsForValue().set("name", "abc", 1, TimeUnit.MINUTES);
            logger.info("name："+ redisTemplate.opsForValue().get("name"));

            stringRedisTemplate.opsForValue().set("key","hello world");
            stringRedisTemplate.opsForValue().set("key","redis", 6);
            System.out.println("***************"+stringRedisTemplate.opsForValue().get("key"));

            /** 覆写指定Key的字符串，从偏移量offset开始 */
            redisTemplate.opsForValue().set("name", "def", 2);
            logger.info("name："+ redisTemplate.opsForValue().get("name"));

        }catch(Exception e) {
            e.printStackTrace();
            return "error";
        }

        return "ok";

    }

    @RequestMapping("/publish")
    public String publish() {
        for (int i = 0; i < 10; i++) {
            /** 向指定通道发送消息 */
            redisTemplate.convertAndSend("myTopic", "这是我发的第"+ i +"条消息");
        }
        return "结束";
    }

    /**
     * Redis消息处理方法
     * @param message
     */
    public void handleMessage(String message) {
        System.out.println("message："+ message);
    }

}
