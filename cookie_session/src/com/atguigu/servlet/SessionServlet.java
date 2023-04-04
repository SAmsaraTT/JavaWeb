package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/2 16:59
 * @Version 1.0
 */
public class SessionServlet extends BaseServlet {
    /**
    * @Description: 创建会话
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        //判断当前session对话是否是新创建的
        boolean aNew = session.isNew();

        //获取会话唯一标识
        String id = session.getId();

        resp.getWriter().write("得到的session id是：" + id + "<br/>");
        resp.getWriter().write("session是否是新创建的：" + aNew + "<br/>");
    }

    /**
    * @Description: store data in session
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "val1");
        resp.getWriter().write("已经住session中保存了数据");
    }

    /**
    * @Description: get the data from the session
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");

        resp.getWriter().write("从session中获取的key1的数据是：" + key1);
    }

    /**
    * @Description: 默认的生命时常
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取默认的超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();

        resp.getWriter().write("Session的默认超时时长为：" + maxInactiveInterval + "秒");
    }

    /**
    * @Description: set a time to expire
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前session已经设置为3秒后超时");
    }

    /**
    * @Description: make session invalid
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        session.invalidate();

        resp.getWriter().write("Session已经设置为超时");
    }
}
