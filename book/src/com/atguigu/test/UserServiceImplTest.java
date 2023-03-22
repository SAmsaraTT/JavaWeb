package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/21 21:43
 * @Version 1.0
 */
public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void register() {
        userService.register(new User("bbj168", "666666", "bbj168@qq.com"));
        userService.register(new User("abc168", "666666", "abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User("bbj168", "6666666", null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("hliu714")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}