package com.hyj.projectlibrary2.service;

import com.hyj.projectlibrary2.bean.Book;

public interface AdminService {
    public Book getBookById(int bookId);
    public void saveBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int bookId);
    public boolean addBook(Book book);
    public boolean adminIsExist(String name);
    public boolean adminLogin(String name,String password);
}
