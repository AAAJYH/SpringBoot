package com.jyh.ordertimeout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单实体
 * @Author: jyh
 * @Date: 2019/4/21 11:56
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private int orderId;

    private Long orderTime;

}
