package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jyh
 * @Date: 2019/4/17 11:07
 */

@RestController
public class RedisController {

    /**
     *
         redisTemplate.opsForValue();//操作字符串
         redisTemplate.opsForHash();//操作hash
         redisTemplate.opsForList();//操作list
         redisTemplate.opsForSet();//操作set
         redisTemplate.opsForZSet();//操作有序set
     *
     */

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping
    public Object redisTest() {
        redisTemplate.opsForValue().set("name", "mote_jyh");
        return redisTemplate.opsForValue().get("name");
    }

}
