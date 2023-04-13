package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/11 16:38
 * @Version 1.0
 */
public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get the Ajax request!");
        Person person = new Person(1, "牛的");

        // compile it to json

        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JQuery Get the Ajax request!");
        Person person = new Person(1, "牛的");

        // compile it to json

        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JQuery_Get get the Ajax request!");
        Person person = new Person(1, "牛的");

        // compile it to json

        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JQuery_Post get the Ajax request!");
        Person person = new Person(1, "牛的");

        // compile it to json

        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JQuery_GetJSON get the Ajax request!");
        Person person = new Person(1, "牛的");

        // compile it to json

        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JQuery_Serialize get the Ajax request!");
        System.out.println("username: " + req.getParameter("username"));
        System.out.println("pin: " + req.getParameter("password"));
        Person person = new Person(1, "牛的");

        // compile it to json

        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }


}
