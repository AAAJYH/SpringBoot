//package com.jyh.kafka;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * @author jyh
// * @version 1.0
// * @date 2020/8/12
// */
//
//@RequestMapping("/kafka")
//@RestController
//public class UserLogController {
//
//    @Resource
//    private UserLogProducer kafkaSender;
//
//    @RequestMapping("/send")
//    public void send() {
//        for (int i = 0; i < 10; i++) {
//            kafkaSender.sendLog(String.valueOf(i));
//        }
//    }
//
//}
