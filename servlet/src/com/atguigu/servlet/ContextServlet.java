package com.atguigu.servlet; /**
 * @Description 测试Context读取数据
 * @Author hliu
 * @Date 2023/3/17 13:39
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、获取 web.xml 中配置的上下文参数 context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        System.out.println("context-param参数username的值是" + username);
        System.out.println("context-param参数password的值是" + password);

//        2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前的工程路径: " + servletContext.getContextPath());
//        3、获取工程部署后在服务器硬盘上的绝对路径
        /**
         *  / 斜杠被服务器解析地址为:http://ip:port/工程名/  映射到IDEA代码的web目录<br/>
         */
        System.out.println("工程部署的绝对路径: " + servletContext.getRealPath("/"));
        System.out.println("工程下css目录的绝对路径：" + servletContext.getRealPath("/css"));
        System.out.println("工程下imgs 1.jpg目录的绝对路径：" + servletContext.getRealPath("/imgs/img.png"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
