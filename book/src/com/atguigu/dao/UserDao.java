package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/21 21:00
 * @Version 1.0
 */
public interface UserDao {
    /**
    * @Description: 根据用户名查询用户信息
    * @Param: [username]
    * @return: com.atguigu.pojo.User
    * @Author: hliu
    * @Date: 2023/3/21
    */
    User queryUserByUsername(String username);
    
    /**
    * @Description: 根据用户名和密码查询
    * @Param: [username, password]
    * @return: com.atguigu.pojo.User
    * @Author: hliu
    * @Date: 2023/3/21
    */
    User queryUserByUsernameAndPassword(String username, String password);
    
    /**
    * @Description: 保存用户信息
    * @Param: [user]
    * @return: int
    * @Author: hliu
    * @Date: 2023/3/21
    */
    int saveUser(User user);

    
}
