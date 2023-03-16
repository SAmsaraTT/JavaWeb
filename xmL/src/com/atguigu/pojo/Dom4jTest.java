package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.util.List;

/**
 * @Description dom4j测试
 * @Author hliu
 * @Date 2023/3/13 16:53
 * @Version 1.0
 */
public class Dom4jTest {
    @Test
    public void test1() {
        //创建一个SaxReader输入流
        try {
            SAXReader saxReader = new SAXReader();

            Document read = saxReader.read("src/books.xml");
            System.out.println(read);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * @Description: 读取xml文件生成对应ORM类
    * @Param: []
    * @return: void
    * @Author: hliu
    * @Date: 2023/3/13
    */
    @Test
    public void test2() {
        try {
            SAXReader saxReader = new SAXReader();

            Document read = saxReader.read("src/books.xml");

            //获取根元素
            Element rootElement = read.getRootElement();

            //查找子元素
            List<Element> books = rootElement.elements("book");

            for (Element book : books) {
                Element element = book.element("name");

                String name = element.getText();
                //直接获取
                String price = book.elementText("price");
                String author = book.elementText("author");

                String sn = book.attributeValue("sn");

                System.out.println(new Book(sn, name, Double.parseDouble(price), author));

            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}


