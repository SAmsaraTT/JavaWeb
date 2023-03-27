package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @Description 下载的Servlet程序
 * @Author hliu
 * @Date 2023/3/26 18:29
 * @Version 1.0
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取下载的文件名
        String downloadFileName = "test.jpg";
        //2.读取下载的内容
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型: " + mimeType);
        resp.setContentType(mimeType);
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("图片.jpg", "UTF-8"));
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);

        //3.获取响应输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //4.读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
