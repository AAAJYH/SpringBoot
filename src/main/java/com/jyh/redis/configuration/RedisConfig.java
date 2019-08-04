//package com.jyh.redis.configuration;
//
//import com.jyh.redis.controller.RedisController;
//import org.springframework.cache.CacheManager;
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @Author: jyh
// * @Date: 2019/4/17 10:43
// */
//
//@Configuration
//@EnableCaching
//public class RedisConfig {
//
//    /**
//     * 设置Redis缓存
//     * @param redisConnectionFactory
//     * @return
//     */
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        CacheManager cacheManager = RedisCacheManager.create(redisConnectionFactory);
//        return cacheManager;
//    }
//
//    /**
//     * 配置RedisTemplate：操作redis的模板
//     * RedisTemplate默认采用的JDK的序列化策略，保存的key和value都是采用此策略保存的，所以需要重新设置key和value的保存策略
//     * StringTemplate默认采用的是String的序列化策略，所以默认就可了，不需要再设置
//     * @param redisConnectionFactory
//     * @return
//     */
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate (RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        /**
//         *  GenericToStringSerializer: 可以将任何对象泛化为字符串并序列化
//         *  Jackson2JsonRedisSerializer: 跟JacksonJsonRedisSerializer实际上是一样的
//         *  JacksonJsonRedisSerializer: 序列化object对象为json字符串
//         *  JdkSerializationRedisSerializer: 序列化java对象（以二进制数组方式存储，没有可读性）
//         *  StringRedisSerializer: 简单的字符串序列化
//         */
//
//        /***
//         * setKeySerializer()：设置key的序列化类型
//         */
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        /** ObjectMapper是Jackson提供的一个类，将java对象和Json格式相互转换 */
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//
//        /***
//         *  setValueSerializer()：设置Value的序列化类型
//         */
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//
//        return redisTemplate;
//    }
//
//    /**
//     * 配置Redis消息监听器
//     * @param redisConnectionFactory
//     * @param messageListenerAdapter
//     * @return
//     */
//    @Bean
//    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
//        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
//        /** 设置消息监听处理对象，并设置通道匹配规则 */
//        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("myTopic"));
//        return redisMessageListenerContainer;
//    }
//
//    /***
//     * 配置监听适配器，指定接收消息的方法，默认handleMessage
//     * @return
//     */
//    @Bean
//    public MessageListenerAdapter messageListenerAdapter() {
//        return new MessageListenerAdapter(new RedisController());
//    }
//
//
//}
