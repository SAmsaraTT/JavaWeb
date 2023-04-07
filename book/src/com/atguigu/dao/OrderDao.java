package com.atguigu.dao;

import com.atguigu.pojo.Order;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/6 20:58
 * @Version 1.0
 */
public interface OrderDao {
    int saveOrder(Order order);
}
