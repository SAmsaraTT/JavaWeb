package com.atguigu.servlet; /**
 * @Description 测试Context存取数据
 * @Author hliu
 * @Date 2023/3/17 14:13
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        System.out.println("保存之前Context1中获取的key1的值是：" + servletContext.getAttribute("key1"));

        servletContext.setAttribute("key1", "val1");

        System.out.println("Context1中获取的key1的值是：" + servletContext.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
