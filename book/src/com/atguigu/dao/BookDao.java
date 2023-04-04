package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/29 14:22
 * @Version 1.0
 */
public interface BookDao {
    int addBook(Book book);


    int deleteBookById(int id);


    int updateBook(Book book);

    Book queryBookById(int id);

    /**
    * @Description: 查询所有图书
    * @Param: []
    * @return: java.util.List<com.atguigu.pojo.Book>
    * @Author: hliu
    * @Date: 2023/3/29
    */
    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
