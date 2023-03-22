package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * @Description Service层
 * @Author hliu
 * @Date 2023/3/21 21:32
 * @Version 1.0
 */
public interface UserService {
    /**
    * @Description: 注册用户
    * @Param: [user]
    * @return: void
    * @Author: hliu
    * @Date: 2023/3/21
    */
    void register(User user);

    /**
    * @Description: 登录
    * @Param: [user]
    * @return: User
    * @Author: hliu
    * @Date: 2023/3/21
    */
    User login(User user);

    /**
    * @Description: 检查用户名是否存在
    * @Param: [username]
    * @return: boolean
    * @Author: hliu
    * @Date: 2023/3/21
    */
    boolean existsUsername(String username);
}
