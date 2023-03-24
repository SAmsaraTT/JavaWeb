package com.atguigu.servlet;

import com.atguigu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 搜索Servlet
 * @Author hliu
 * @Date 2023/3/23 21:53
 * @Version 1.0
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1。获取请求的参数
        //2.发sql语句查询学生的信息
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student(i + 1, "name" + (i + 1), 18 + i + 1, "phone" + i + 1));
        }
        //3.保存查询到的结果
        req.setAttribute("stuList", studentList);
        //4.请求转发到showStudent.jsp
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);
    }
}
