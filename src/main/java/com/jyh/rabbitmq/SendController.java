package com.jyh.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jyh
 * @Date: 2019/4/1 11:11
 */

@RestController
public class SendController {

    @Autowired
    private SendMessage firstSender;

    @GetMapping("/send")
    public String send(String message){
        firstSender.send(message);
        return "ok";
    }

}
