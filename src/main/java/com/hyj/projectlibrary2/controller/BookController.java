package com.hyj.projectlibrary2.controller;

import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
@Api(tags = "图书管理")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    @ApiOperation("获取所有图书")
    public List<Book> getAllBooks() {
        return bookService.list();
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID获取图书")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping
    @ApiOperation("添加图书")
    public void addBook(@RequestBody Book book) {
        bookService.save(book);
    }

    @PutMapping("/{id}")
    @ApiOperation("更新图书")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除图书")
    public void deleteBook(@PathVariable Long id) {
        bookService.removeById(id);
    }
}