package com.atguigu.service.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/29 15:27
 * @Version 1.0
 */
public class BooksServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(items);

        return page;
    }
}
