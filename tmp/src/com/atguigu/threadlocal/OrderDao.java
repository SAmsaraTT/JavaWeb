package com.atguigu.threadlocal;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/9 15:35
 * @Version 1.0
 */
public class OrderDao {
    public void saveOrder() {
        String name = Thread.currentThread().getName();

        System.out.println("OrderDao" + name + "中保存的数据是" + ThreadLocalTest.threadLocal.get());
    }
}
