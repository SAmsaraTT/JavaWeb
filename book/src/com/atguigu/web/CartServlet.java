package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BooksServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/5 16:21
 * @Version 1.0
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BooksServiceImpl();

    /**
    * @Description: add item to cart
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/5
    */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//
//        System.out.println("id = " + req.getParameter("id"));

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        req.getSession().setAttribute("lastName", cartItem.getName());

        // redirect to the original page
        resp.sendRedirect(req.getHeader("Referer"));
    }
    
    /***
    * @Description: use the ajax to add items to the cart
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/12
    */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//
//        System.out.println("id = " + req.getParameter("id"));

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        req.getSession().setAttribute("lastName", cartItem.getName());

//        // redirect to the original page
//        resp.sendRedirect(req.getHeader("Referer"));

        Map<String, Object> ret = new HashMap<>();
        ret.put("totalCount", cart.getTotalCount());
        ret.put("lastName", cartItem.getName());

        Gson gson = new Gson();

        String json = gson.toJson(ret);

        resp.getWriter().write(json);

    }

    /**
    * @Description: remove the item from the cart
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/5
    */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.deleteItem(id);

            //redirect to original page
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
    * @Description: clear the cart
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/5
    */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.clear();

            //redirect to original page
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
    * @Description: update the count of item in the cart
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/5
    */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.updateCount(id, count);

            //redirect to original page
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
