package com.hyj.projectlibrary2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyj.projectlibrary2.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BookDao extends BaseMapper<Book>{
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
}
