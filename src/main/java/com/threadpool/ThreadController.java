package com.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jyh
 * @Date: 2019/4/11 10:18
 */

@RestController
public class ThreadController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/aaa")
    public String aaa() {

        /** 调用service层的任务 */
        asyncService.executeAsync();

        return "OK";

    }

}
