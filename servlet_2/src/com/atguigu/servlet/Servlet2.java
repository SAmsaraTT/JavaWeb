package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 测试请求转发
 * @Author hliu
 * @Date 2023/3/18 14:23
 * @Version 1.0
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("在Servlet2中查看" + username);

        //查看柜台1是否盖章
        Object key1 = req.getAttribute("key1");
        System.out.println("柜台1是否有章: " + key1);

        //处理自己的业务

        System.out.println("Servlet2 处理自己的业务");
    }
}
