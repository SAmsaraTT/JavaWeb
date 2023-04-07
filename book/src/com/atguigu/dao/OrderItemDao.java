package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/6 20:59
 * @Version 1.0
 */
public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
}
