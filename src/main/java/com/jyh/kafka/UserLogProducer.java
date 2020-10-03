//package com.jyh.kafka;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author jyh
// * @version 1.0
// * @date 2020/8/12
// */
//
//@Component
//public class UserLogProducer {
//
//    @Resource
//    private KafkaTemplate kafkaTemplate;
//
//    public void sendLog(String userId) {
//        UserLog userLog = new UserLog();
//        userLog.setUserName("jhp");
//        userLog.setUserId(userId);
//        userLog.setState("0");
//        System.out.println("发送用户日志数据：" + userLog);
//        kafkaTemplate.send("user-log", JSON.toJSONString(userLog));
//    }
//
//}
