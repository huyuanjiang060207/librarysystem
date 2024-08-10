package com.hyj.projectlibrary2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.mapper.BookMapper;
import com.hyj.projectlibrary2.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
