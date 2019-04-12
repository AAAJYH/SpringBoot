package com.threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: jyh
 * @Date: 2019/4/10 9:59
 */

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        /** 设置核心线程数 */
        threadPool.setCorePoolSize(5);
        /** 设置最大线程 */
        threadPool.setMaxPoolSize(10);
        /** 设置队列容量 */
        threadPool.setQueueCapacity(20);
        /** 设置线程活跃时间（秒） */
        threadPool.setKeepAliveSeconds(60);
        /** 设置默认线程名称 */
        threadPool.setThreadNamePrefix("defaultThreadPool");
        /** 设置拒绝策略 */
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        /** 设置拒绝策略 */
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        return threadPool;
    }

}
