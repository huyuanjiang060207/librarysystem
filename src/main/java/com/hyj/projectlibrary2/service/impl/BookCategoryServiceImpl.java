package com.hyj.projectlibrary2.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyj.projectlibrary2.bean.BookCategory;
import com.hyj.projectlibrary2.mapper.BookCategoryMapper;
import com.hyj.projectlibrary2.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryMapper bookCategoryMapper;
    @Override
    public Page<BookCategory> selectBookCategoryByPageNum(int pageNum) {
        Page<BookCategory> page=new Page<>();
        List<BookCategory> list=bookCategoryMapper.selectByPageNum((pageNum-1)*10,10);
        page.setPageSize(10);
        page.setPageNum(pageNum);
        page.setList(list);
        int recordCount=bookCategoryMapper.selectAllCount();
        int pageCount=recordCount/10;
        if(recordCount%10!=0){
            pageCount++;
        }
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public int deleteBookCategoryById(int bookCategoryId) {
        return bookCategoryMapper.deleteByPrimaryKey(bookCategoryId);
    }
}
