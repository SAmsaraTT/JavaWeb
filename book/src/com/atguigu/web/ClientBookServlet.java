package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BooksServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/1 21:29
 * @Version 1.0
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BooksServiceImpl();

    /**
     * @Description: 处理分页功能
     * @Param: [req, resp]
     * @return: void
     * @Author: hliu
     * @Date: 2023/3/31
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取pageNo, pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.invoke BookService.page(pageNo, pageSize)
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3. store the page in RequestScope
        req.setAttribute("page", page);
        //4.request dispatch
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
