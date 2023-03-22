package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/21 21:05
 * @Version 1.0
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ?";
        return queryForOne(sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ? and password = ?";
        return queryForOne(sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(username, `password`, `email`) VALUES(?, ?, ?)";

        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
