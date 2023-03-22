package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/21 21:12
 * @Version 1.0
 */
public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误！");
        } else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User("hliu", "123456", "skulllht@gmail.com")));
    }
}