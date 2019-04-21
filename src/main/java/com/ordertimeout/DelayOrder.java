package com.ordertimeout;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时队列实现订单超时处理
 * @Author: jyh
 * @Date: 2019/4/20 9:00
 */

@Data
public class DelayOrder implements Delayed{

    private int orderId;
    private Date orderTime;
    private Long expireTime = 5000L;

    public static DelayQueue<DelayOrder> delayQueue;
    static {
        new DelayQueue<>();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        System.out.println(orderTime.getTime() + expireTime - System.currentTimeMillis()+ "毫秒");
        return  this.orderTime.getTime() + expireTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return this.orderTime.getTime() - ((DelayOrder) o).orderTime.getTime() > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(DelayOrder.class);

        /** 订单1 */
        DelayOrder delayOrder = new DelayOrder();
        delayOrder.setOrderTime(new Date());
        delayOrder.setOrderId(1);
        /** 加入到延时队列中 */
        delayQueue.offer(delayOrder);
        System.out.println(delayOrder.getOrderId()+ "订单1加入时间："+ delayOrder.getOrderTime());

        /** 订单2 */
        DelayOrder delayOrder2 = new DelayOrder();
        delayOrder2.setOrderTime(new Date());
        delayOrder2.setOrderId(2);
        /** 加入到延时队列中 */
        delayQueue.offer(delayOrder2);
        System.out.println(delayOrder2.getOrderId()+ "订单2加入时间："+ delayOrder2.getOrderTime());

        /** 启动线程 */
        consum();
    }

    private static void consum() {
            while(true) {
                try {

                    /** take()：底层取队列中第一个元素循环去判断getDelay是否小于零（是否超时）
                     *  第一个元素处理完后移除，下一个元素向前移位，DelayQueue为空时线程等待
                     */
                    DelayOrder delayOrder = delayQueue.take();
                    System.out.println("现在时间是："+ delayOrder.getOrderTime()+ "，订单过期："+ delayOrder.getOrderId());

                    /**
                     * @TODO 订单超时，修改订单状态
                     */

                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
    }

}
