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
        page.setUrl("client/bookServlet?action=page");
        //3. store the page in RequestScope
        req.setAttribute("page", page);
        //4.request dispatch
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    /**
    * @Description: 查询对应价格区间的图书
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/2
    */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取pageNo, pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        //2.invoke BookService.page(pageNo, pageSize)
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }

        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3. store the page in RequestScope
        req.setAttribute("page", page);
        //4.request dispatch
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
