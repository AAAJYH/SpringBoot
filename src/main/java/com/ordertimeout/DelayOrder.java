package com.ordertimeout;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时队列实现订单超时处理
 * @Author: jyh
 * @Date: 2019/4/20 9:00
 */

@Data
public class DelayOrder extends Order implements Delayed{

    Logger logger = LoggerFactory.getLogger(DelayOrder.class);

    /** 超时毫秒 */
    private final Long expireTime = 5000L;

    /** 初始化延时队列 */
    public static DelayQueue<DelayOrder> delayQueue;
    static {
        delayQueue = new DelayQueue<DelayOrder>();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        logger.info(this.getOrderTime() + expireTime - System.currentTimeMillis()+ "毫秒");
        return  this.getOrderTime() + expireTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return this.getOrderTime() - ((DelayOrder) o).getOrderTime() > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(DelayOrder.class);

        /** 订单1 */
        DelayOrder delayOrder = new DelayOrder();
        delayOrder.setOrderTime(System.currentTimeMillis());
        delayOrder.setOrderId(1);
        /** 加入到延时队列中 */
        delayQueue.offer(delayOrder);
        logger.info(delayOrder.getOrderId()+ "订单1加入时间："+ delayOrder.getOrderTime());

        /** 订单2 */
        DelayOrder delayOrder2 = new DelayOrder();
        delayOrder2.setOrderTime(System.currentTimeMillis());
        delayOrder2.setOrderId(2);
        /** 加入到延时队列中 */
        delayQueue.offer(delayOrder2);
        logger.info(delayOrder2.getOrderId()+ "订单2加入时间："+ delayOrder2.getOrderTime());

        /** 启动线程 */
        consum();
    }

    private static void consum() {
        Logger logger = LoggerFactory.getLogger(DelayOrder.class);

        while(true) {
                try {

                    /** take()：底层取队列中第一个元素循环去判断getDelay是否小于零（是否超时）
                     *  第一个元素处理完后移除，下一个元素向前移位，DelayQueue为空时线程等待
                     */
                    DelayOrder delayOrder = delayQueue.take();
                    logger.info("现在时间是："+ delayOrder.getOrderTime()+ "，订单过期："+ delayOrder.getOrderId());

                    /**
                     * @TODO 订单超时，修改订单状态
                     */

                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
    }

}
