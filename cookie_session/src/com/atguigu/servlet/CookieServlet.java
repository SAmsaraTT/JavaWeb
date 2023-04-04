package com.atguigu.servlet;

import com.atguigu.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/2 13:53
 * @Version 1.0
 */
public class CookieServlet extends BaseServlet {

    /**
    * @Description: 创建Cookie
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie cookie = new Cookie("key1", "val1");
        Cookie cookie1 = new Cookie("key2", "val2");

        //2.通知客户端保存cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie1);

        resp.getWriter().write("Cookie创建成功！");
    }

    /**
    * @Description: 获取cookie
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        Cookie target = CookieUtils.findCookie("key1", cookies);


        for (Cookie cookie : cookies) {
            resp.getWriter().write("[ " + cookie.getName() + " = " + cookie.getValue() + " ]<br/>");
        }


        if (target != null) {
            resp.getWriter().write("找到了需要的Cookie");
        }
    }

    /**
    * @Description: 更新cookie
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie = new Cookie("key1", "newVal1");
//        resp.addCookie(cookie);

        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie != null) {
            cookie.setValue("newVal2");
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key2已经修改！");
    }
    /**
    * @Description: 默认生存时间
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);

        resp.addCookie(cookie);
    }

    /**
    * @Description: 马上删除
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie key1 = CookieUtils.findCookie("key1", req.getCookies());

        if (key1 != null) {
            key1.setMaxAge(0);
            resp.addCookie(key1);

            resp.getWriter().write("key1已经删除！");
        }
    }

    /**
    * @Description: 指定存活时间
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);

        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时cookie");
    }

    /**
    * @Description: 测试工厂路径属性
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有path路径的cookie");
    }
}
