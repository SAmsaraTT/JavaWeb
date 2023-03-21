package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 测试请求重定向
 * @Author hliu
 * @Date 2023/3/18 15:34
 * @Version 1.0
 */

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游 Response1");

        req.setAttribute("key1", "GG");

        //设置响应状态码302，表示重定向（已搬迁）
//        resp.setStatus(302);

        //设置响应头，说明新的地址在哪里
//        resp.setHeader("Location", "http://localhost:8080/TestServlet/response2");

        //可以访问外部资源
//        resp.setHeader("Location", "http://www.douyu.com");

        //第二种方式

        resp.sendRedirect("http://localhost:8080/TestServlet/response2");
    }
}
