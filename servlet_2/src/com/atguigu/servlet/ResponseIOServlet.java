package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 演示两个输出流
 * @Author hliu
 * @Date 2023/3/18 15:09
 * @Version 1.0
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(resp.getCharacterEncoding());


        //设置服务器字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");

        //通过响应头设置浏览器也使用UTF-8
//        resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        //同时设置服务器和客户端(要在获取流之前调用）
        resp.setContentType("text/html; charset=UTF-8");
        System.out.println(resp.getCharacterEncoding());

        PrintWriter writer = resp.getWriter();
        writer.write("牛的");
    }
}
