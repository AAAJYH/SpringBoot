package com.jyh.startload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 在项目启动时调用这个方法
 * @Order：执行的循序
 * @Author: jyh
 * @Date: 2019/4/12 15:46
 */

@Component
@Order(1)
public class LoadOne implements CommandLineRunner{

    private Logger logger = LoggerFactory.getLogger(LoadOne.class);

    /**
     * 用于运行bean的回调
     * @param args 传入的主要方法参数
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("LoadOne--Order 1");
    }

}
