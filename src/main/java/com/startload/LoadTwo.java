package com.startload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 项目启动时执行这个方法
 * @Order：执行的顺序
 * @Author: jyh
 * @Date: 2019/4/12 15:46
 */

@Component
@Order(2)
public class LoadTwo implements ApplicationRunner{

    private Logger logger = LoggerFactory.getLogger(LoadOne.class);

    /**
     * 用于运行bean的回调
     * @param args 传入应用程序参数
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("args："+ args.getOptionNames());
        logger.info("LoadTwo");
    }

}
