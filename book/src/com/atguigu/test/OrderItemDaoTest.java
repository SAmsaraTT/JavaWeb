package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/6 21:12
 * @Version 1.0
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null, "java", 1, new BigDecimal(100), new BigDecimal(100), "123456790"));
        orderItemDao.saveOrderItem(new OrderItem(null, "js", 2, new BigDecimal(100), new BigDecimal(200), "123456790"));
        orderItemDao.saveOrderItem(new OrderItem(null, "c++", 1, new BigDecimal(100), new BigDecimal(100), "123456790"));
    }
}