package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BooksServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/29 15:30
 * @Version 1.0
 */
public class BooksServiceImplTest {
    private BookService bookService = new BooksServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "AA", "BB", new BigDecimal(100000), 123123, 3, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "CC", "DD", new BigDecimal(100000), 123123, 3, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
}