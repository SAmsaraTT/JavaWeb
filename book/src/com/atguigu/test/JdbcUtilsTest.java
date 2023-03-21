package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

/**
 * @Description JDBC工具类的测试类
 * @Author hliu
 * @Date 2023/3/20 23:42
 * @Version 1.0
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        System.out.println(JdbcUtils.getConnection());
    }
}
