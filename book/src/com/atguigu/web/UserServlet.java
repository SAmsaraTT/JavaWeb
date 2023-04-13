package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Description 合并多个Servlet程序
 * @Author hliu
 * @Date 2023/3/28 11:34
 * @Version 1.0
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
    * @Description: 登录
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/3/28
    */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1。获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用service处理业务
        User login = userService.login(new User(username, password, null));
        if (login == null) {
            System.out.println("登录失败");
            //把错误信息和回显信息保存到request域中

            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            System.out.println(login);
            // 保存用户登录后的信息到session域中
            req.getSession().setAttribute("user", login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        //删除验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1.获取请求参数

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2.检查验证码
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                //不可用
                System.out.println("用户名[" + username + "]已存在");

                //保存回显信息
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //可用
                userService.register(new User(username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //保存回显信息
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            //跳回注册页面
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    /**
    * @Description: logout the account
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/3
    */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        resp.sendRedirect(req.getContextPath());
    }

    /**
    * @Description: use the ajax to check if username name existed
    * @Param: [req, resp]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/12
    */
    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        boolean existsUsername = userService.existsUsername(username);

        Map<String, Object> ret = new HashMap<>();

        ret.put("existsUsername", existsUsername);

        Gson gson = new Gson();

        String json = gson.toJson(ret);

        resp.getWriter().write(json);
    }
}
