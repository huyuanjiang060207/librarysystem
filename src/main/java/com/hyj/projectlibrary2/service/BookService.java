package com.hyj.projectlibrary2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyj.projectlibrary2.bean.Book;

import java.util.List;

public interface BookService extends IService<Book> {
    public List<Book> findBooksByBookName(String bookName);
    public Page<Book> findBooksByCategoryId(int categoryId, int pageNum);
    void decreaseBook(int bookId);
    void increaseBook(int bookId);
}
