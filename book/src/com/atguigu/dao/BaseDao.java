package com.atguigu.dao;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/21 16:53
 * @Version 1.0
 */
public abstract class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> type = null;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        this.type = (Class<T>) actualTypeArguments[0];
    }



    /**
    * @Description: 执行数据库更新操作
    * @Param: []
    * @return: int
    * @Author: hliu
    * @Date: 2023/3/21
    */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(connection);
        }
    }
    
    /**
    * @Description: 查询并返回一条javaBean
    * @Param: [sql, args]
    * @return: T
    * @Author: hliu
    * @Date: 2023/3/21
    */
    public T queryForOne(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        T t = null;
        try {
            t = queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(connection);
        }
    }

    /**
    * @Description: 返回多条查询记录
    * @Param: [sql, args]
    * @return: java.util.List<T>
    * @Author: hliu
    * @Date: 2023/3/21
    */
    public List<T> queryForList(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        List<T> list = null;

        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(connection);
        }
    }

    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        Object count = null;
        try {
            count = queryRunner.query(connection, sql, new ScalarHandler(), args);
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(connection);
        }

    }
}
