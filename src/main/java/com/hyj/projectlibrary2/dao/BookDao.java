package com.hyj.projectlibrary2.dao;

import jakarta.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDao {

    private final static String NAMESPACE = "com.hyj.projectlibrary2.dao.BookDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public int matchBook(final String searchWord) {
        String search = "%" + searchWord + "%";
        return sqlSessionTemplate.selectOne(NAMESPACE + "matchBook", search);
    }

    public ArrayList<Book> queryBook(final String searchWord) {
        String search = "%" + searchWord + "%";
        List<Book> result = sqlSessionTemplate.selectList(NAMESPACE + "queryBook", search);
        return (ArrayList<Book>) result;
    }

    public ArrayList<Book> getAllBooks() {
        List<Book> result = sqlSessionTemplate.selectList(NAMESPACE + "getAllBooks");
        return (ArrayList<Book>) result;
    }

    public int addBook(final Book book) {
        return sqlSessionTemplate.insert(NAMESPACE + "addBook", book);
    }

    public Book getBook(final long bookid) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getBook", bookid);
    }

    public int editBook(final Book book) {
        return sqlSessionTemplate.update(NAMESPACE + "editBook", book);
    }

    public int deleteBook(final long bookid) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteBook", bookid);
    }
}
