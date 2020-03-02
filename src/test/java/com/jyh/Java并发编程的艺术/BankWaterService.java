package com.jyh.Java并发编程的艺术;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author jyh
 * @date 2020/1/13
 * @description
 */

public class BankWaterService implements Runnable {

    /**
     * 创建4个屏障
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    /**
     * 线程池
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算的银行流水
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i=0; i<4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前sheet银行数据
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // 银行计算完成，插入一个屏障
                    try {
                        c.await();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        new BankWaterService().count();
    }

}
