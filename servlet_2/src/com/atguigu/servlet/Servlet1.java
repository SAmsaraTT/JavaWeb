package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
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
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看" + username);

        //传递到Servlet2中
        req.setAttribute("key1", "柜台1的章");

        //问路
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        //获取web-inf中的资源
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");

        //进入Servlet2

        requestDispatcher.forward(req, resp);
    }
}
