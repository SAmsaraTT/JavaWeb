package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Description 测试获取请求的参数值
 * @Author hliu
 * @Date 2023/3/17 21:51
 * @Version 1.0
 */
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");


        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("爱好：" + Arrays.asList(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集为UTF-8,获取请求调用之前使用
        req.setCharacterEncoding("UTF-8");
        //获取请求的参数
        System.out.println("-------POST----------");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");


        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("爱好：" + Arrays.asList(hobby));
    }
}
