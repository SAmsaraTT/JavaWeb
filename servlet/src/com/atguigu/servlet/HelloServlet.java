package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description Servlet测试
 * @Author hliu
 * @Date 2023/3/16 12:59
 * @Version 1.0
 */
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");

        //1.获取Servlet程序的别名(servlet-name)
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());

        //2.获取初始化参数init-param
        System.out.println("初始化参数username的值是；" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是；" + servletConfig.getInitParameter("url"));

        //3.获取ServletContext对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * Service方法专门处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 Hello Servlet被访问了");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //获取请求的方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    /**
    * @Description: 做get请求
    * @Param: []
    * @return: void
    * @Author: hliu
    * @Date: 2023/3/16
    */
    public void doGet() {
        System.out.println("get请求");
        System.out.println("get请求");
    }

    /**
    * @Description: 做post请求
    * @Param: []
    * @return: void
    * @Author: hliu
    * @Date: 2023/3/16
    */
    public void doPost() {
        System.out.println("post请求");
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy销毁方法");
    }
}
