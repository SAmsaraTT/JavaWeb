package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description 上传文件的servlet程序
 * @Author hliu
 * @Date 2023/3/26 17:35
 * @Version 1.0
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件上传过来了");

        //1.先判断是否为多段数据
        if (ServletFileUpload.isMultipartContent(req)) {
            //创建fileItemFactory
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            //解析上传的数据
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);

                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //普通
                        System.out.println("name: " + fileItem.getFieldName());
                        //设置编码格式
                        System.out.println("value: " + fileItem.getString("UTF-8"));
                    } else {
                        System.out.println("name: " + fileItem.getFieldName());
                        System.out.println("fileName: " + fileItem.getName());
                        fileItem.write(new File("D:\\javaW\\imgs\\test.jpg"));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
