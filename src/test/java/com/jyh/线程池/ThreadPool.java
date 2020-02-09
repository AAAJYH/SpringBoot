package com.jyh.线程池;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPool {

    ThreadPoolExecutor threadPoolExecutor;
    {
        threadPoolExecutor = new ThreadPoolExecutor(2, 1000, 10000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
    }

    @Test
    public void a() throws ExecutionException, InterruptedException, TimeoutException {
        for (int i = 0; i < 1000; i++) {
            System.out.println(threadPoolExecutor.getPoolSize() + " " + threadPoolExecutor.getQueue().size());
            Future future = threadPoolExecutor.submit(new Operation());
            System.out.println("submit get " + future.get(1000, TimeUnit.SECONDS));
//            threadPoolExecutor.execute(new Operation());
        }
    }

}
