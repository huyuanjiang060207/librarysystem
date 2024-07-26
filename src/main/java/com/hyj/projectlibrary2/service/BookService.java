package com.hyj.projectlibrary2.service;

import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.dao.BookDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public ArrayList<Book> queryBook(String searchWord) {
        return bookDao.queryBook(searchWord);
    }

    public ArrayList<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public boolean matchBook(String searchWord) {
        return bookDao.matchBook(searchWord) > 0;
    }

    public boolean addBook(Book book) {
        return bookDao.addBook(book) > 0;
    }

    public Book getBook(Long bookId) {
        return bookDao.getBook(bookId);
    }

    public boolean editBook(Book book) {
        return bookDao.editBook(book) > 0;
    }

    public boolean deleteBook(Long bookId) {
        return bookDao.deleteBook(bookId) > 0;
    }

}
