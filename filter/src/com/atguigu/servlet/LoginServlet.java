package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/7 18:15
 * @Version 1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("hliu714".equals(username) && "123456".equals(password)) {
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("login success!");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
