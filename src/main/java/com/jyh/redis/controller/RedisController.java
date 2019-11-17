//package com.jyh.redis.controller;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombokTest.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.data.redis.support.atomic.RedisAtomicLong;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Author: jyh
// * @Date: 2019/4/17 11:07
// */
//
//@RestController
//@Api(tags = "Redis控制层")
//@Log4j2
//public class RedisController {
//
//    /**
//         redisTemplate.opsForValue();//操作字符串
//         redisTemplate.opsForHash();//操作hash
//         redisTemplate.opsForList();//操作list
//         redisTemplate.opsForSet();//操作set
//         redisTemplate.opsForZSet();//操作有序set
//     */
//
//    @Autowired
//    RedisTemplate<String, Object> redisTemplate;
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @ApiOperation(value = "获取Redis自增id")
//    @RequestMapping("getAutoIncrement")
//    private Long getAutoIncrement(String key) {
//        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
//        Long counter = redisAtomicLong.incrementAndGet();
//        if(counter.equals(1L)) {
//            System.out.println("设置过期时间为1天");
//            redisAtomicLong.expire(5, TimeUnit.MILLISECONDS);
//        }
//        return counter;
//    }
//
//    @GetMapping
//    public String redisTest() {
//        try{
//
//            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
//
//            /** 设置过期时间，单位分钟 */
//            redisTemplate.opsForValue().set("name", "abc", 1, TimeUnit.MINUTES);
//            log.info("name："+ redisTemplate.opsForValue().get("name"));
//
//            stringRedisTemplate.opsForValue().set("key","hello world");
//            stringRedisTemplate.opsForValue().set("key","redis", 6);
//            System.out.println("***************"+stringRedisTemplate.opsForValue().get("key"));
//
//            /** 覆写指定Key的字符串，从偏移量offset开始 */
//            redisTemplate.opsForValue().set("name", "def", 2);
//            log.info("name："+ redisTemplate.opsForValue().get("name"));
//
//        }catch(Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//
//        return "ok";
//
//    }
//
//    @RequestMapping("/publish")
//    public String publish() {
//        int number = 10;
//        for (int i = 0; i < number; i++) {
//            /** 向指定通道发送消息 */
//            redisTemplate.convertAndSend("myTopic", "这是我发的第"+ i +"条消息");
//        }
//        return "结束";
//    }
//
//    /**
//     * Redis消息处理方法
//     * @param message
//     */
//    public void handleMessage(String message) {
//        System.out.println("message："+ message);
//    }
//
//}
