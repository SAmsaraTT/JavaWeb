package com.atguigu.threadlocal;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/9 15:25
 * @Version 1.0
 */
public class OrderService {
    public void createOrder() {
        String name = Thread.currentThread().getName();

        System.out.println("OrderService" + name + "中保存的数据是" + ThreadLocalTest.threadLocal.get());
        new OrderDao().saveOrder();
    }
}
