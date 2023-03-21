package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description JDBC工具类
 * @Author hliu
 * @Date 2023/3/20 23:22
 * @Version 1.0
 */
public class JdbcUtils {
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * @Description: 获取数据库连接
    * @Param: []
    * @return: java.sql.Connection
    * @Author: hliu
    * @Date: 2023/3/20
    */
    public static Connection getConnection() {
        Connection connection = null;
        try {
             connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    /**
    * @Description: 关闭连接
    * @Param: [connection]
    * @return: void
    * @Author: hliu
    * @Date: 2023/3/20
    */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
