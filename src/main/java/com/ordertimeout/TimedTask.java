package com.ordertimeout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 定时任务实现订单超时处理
 * @Author: jyh
 * @Date: 2019/4/21 11:54
 */

public class TimedTask extends Order implements Runnable{

    private Logger logger = LoggerFactory.getLogger(TimedTask.class);

    /** 超时毫秒 */
    private static Long expireTime;
    /** 订单集合 */
    private static List<Order> orderList;
    static {
        orderList = new LinkedList<Order>();
        expireTime = 5000L;
    }

    @Override
    public void run() {

        while(true) {
            if(orderList.size() > 0) {

                Long currentMillis = System.currentTimeMillis();
                Iterator<Order> orderIterator = orderList.iterator();
                while (orderIterator.hasNext()) {
                    Order o = orderIterator.next();
                    logger.info("o：" + o);
                    if (o.getOrderTime() + expireTime - currentMillis < 0) {
                        logger.info("订单 " + o.getOrderId() + " 超时了");
                        orderIterator.remove();
                        /***
                         * TODO：修改订单状态
                         */
                    }
                }

            }else {
                logger.info("没有订单了");
            }

            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /** 订单1 */
        Order order1 = new Order(1, System.currentTimeMillis());
        /** 订单2 */
        Order order2 = new Order(2, System.currentTimeMillis());
        /**  添加到订单集合中 */
        orderList.add(order1);
        orderList.add(order2);

        /** 启动处理超市订单线程 */
        Thread thread = new Thread(new TimedTask());
        thread.start();
    }

}
