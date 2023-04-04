package com.atguigu.utils;

import javax.servlet.http.Cookie;

/**
 * @Description Cookie工具类
 * @Author hliu
 * @Date 2023/4/2 14:26
 * @Version 1.0
 */
public class CookieUtils {
    /**
    * @Description: 查找指定名称的Cookie对象
    * @Param: [name, cookies]
    * @return: javax.servlet.http.Cookie
    * @Author: hliu
    * @Date: 2023/4/2
    */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }
}
