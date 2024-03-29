package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/29 14:59
 * @Version 1.0
 */
public interface BookService {
    void addBook(Book book);

    void deleteBookById(int id);

    void updateBook(Book book);

    Book queryBookById(int id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
