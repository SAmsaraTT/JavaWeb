package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/6 21:15
 * @Version 1.0
 */
public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
