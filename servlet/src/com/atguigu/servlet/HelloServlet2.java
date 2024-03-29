package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 测试Servlet子类
 * @Author hliu
 * @Date 2023/3/16 18:04
 * @Version 1.0
 */
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写了init方法做了一些工作");
    }

    /**
     * 在get请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doGet方法");

        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);

        System.out.println("初始化参数username的值是；" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是；" + servletConfig.getInitParameter("url"));
    }

    /**
     * 在post请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doPost方法");
    }
}
