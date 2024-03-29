package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 测试Request方法
 * @Author hliu
 * @Date 2023/3/17 21:26
 * @Version 1.0
 */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        i. getRequestURI() 获取请求的资源路径
        System.out.println("URI => " + req.getRequestURI());
//        ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("URL => " + req.getRequestURL());
//        iii. getRemoteHost() 获取客户端的 ip 地址
        /**
         * 在 IDEA 中，使用 localhost 访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在 IDEA 中，使用 127.0.0.1 访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在 IDEA 中，使用 真实 ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址<br/>
         */
        System.out.println("客户端ip地址 => " + req.getRemoteHost());
//        iv. getHeader() 获取请求头
        System.out.println("获取请求头 =>" + req.getHeader("User-Agent"));
//        vii. getMethod() 获取请求的方式 GET 或 POST
        System.out.println("请求的方式 =>" + req.getMethod());
    }
}
