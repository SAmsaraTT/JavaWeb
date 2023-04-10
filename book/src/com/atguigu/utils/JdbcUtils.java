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
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
        Connection connection = connectionThreadLocal.get();

        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                //store the connection in the TreadLocal
                connectionThreadLocal.set(connection);

                connection.setAutoCommit(false);


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

    /**
     * @Description: commit and close the connection
     * @Param: []
     * @return: void
     * @Author: hliu
     * @Date: 2023/4/9
     */
    public static void commitAndClose() {
        Connection connection = connectionThreadLocal.get();

        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // have to remove the connection in the ThreadLocal
        connectionThreadLocal.remove();
    }

    /**
     * @Description: rollback and close the connection
     * @Param: []
     * @return: void
     * @Author: hliu
     * @Date: 2023/4/9
     */
    public static void rollbackAndClose() {
        Connection connection = connectionThreadLocal.get();

        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // have to remove the connection in the ThreadLocal
        connectionThreadLocal.remove();
    }

    /**
     * @Description: 关闭连接
     * @Param: [connection]
     * @return: void
     * @Author: hliu
     * @Date: 2023/3/20
     */
    @Deprecated
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
