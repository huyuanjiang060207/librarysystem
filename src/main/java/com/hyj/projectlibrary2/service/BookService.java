package com.hyj.projectlibrary2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.dao.BookDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BookService extends ServiceImpl<BookDao, Book> {
    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public Book getBookById(Long id) {
        return bookDao.getBookById(id);
    }

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void deleteBook(Long id) {
        bookDao.deleteBook(id);
    }
}
