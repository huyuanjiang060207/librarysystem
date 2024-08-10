package com.hyj.projectlibrary2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyj.projectlibrary2.bean.Admin;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.bean.BookCategory;
import com.hyj.projectlibrary2.mapper.AdminMapper;
import com.hyj.projectlibrary2.mapper.BookCategoryMapper;
import com.hyj.projectlibrary2.mapper.BookMapper;
import com.hyj.projectlibrary2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean addBook(Book book) {
        int n=bookMapper.insert(book);
        if(n>0){
            return true;
        }
        return false;
    }
    public boolean addBookCategory(BookCategory bookCategory) {
        int n= BookCategoryMapper.insert(bookCategory);
        if(n>0){
            return true;
        }
        return false;
    }

}
