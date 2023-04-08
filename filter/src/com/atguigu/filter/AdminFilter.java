package com.atguigu.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/7 17:45
 * @Version 1.0
 */
public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1.Filter Constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter init");

        //1.get the filter-name
        System.out.println("filter-name: " + filterConfig.getFilterName());
        //2.get the init-param in the web.xml
        System.out.println("init-param: " + filterConfig.getInitParameter("username"));
        System.out.println("init-param: " + filterConfig.getInitParameter("url"));

        //3.get the servlet context
        System.out.println(filterConfig.getServletContext());
    }

    /**
    * @Description: stop the request
    * @Param: [servletRequest, servletResponse, filterChain]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/7
    */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.Filter doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();

        Object user = session.getAttribute("user");

        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
            //resume the process
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy");
    }
}
