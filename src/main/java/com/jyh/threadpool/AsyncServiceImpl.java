package com.jyh.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: jyh
 * @Date: 2019/4/10 16:39
 */

@Service
public class AsyncServiceImpl implements AsyncService {
    Logger logger = LoggerFactory.getLogger(AsyncService.class);

    /**
     * 异步
     */
    @Override
    @Async("taskExecutor")
    public void executeAsync() {
        logger.info("start executeAsync");
        try{
            System.out.println("当前运行线程的名字："+ Thread.currentThread().getName());
        }catch(Exception e) {
            e.printStackTrace();
        }
        logger.info("end executeAsync");
    }
}
