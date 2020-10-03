//package com.jyh.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
///**
// * @author jyh
// * @version 1.0
// * @date 2020/8/12
// */
//
//@Component
//public class UserLogConsumer {
//
//    @KafkaListener(topics = {"user-log"})
//    public void consumer(ConsumerRecord<?,?> consumerRecord) {
//        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
//        System.out.println(">>>>>>>>>> record = " + kafkaMessage);
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            System.out.println("消费消息：" + message);
//        }
//    }
//
//}
