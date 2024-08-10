package com.hyj.projectlibrary2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyj.projectlibrary2.bean.BookCategory;

public interface BookCategoryService {
    public Page<BookCategory> selectBookCategoryByPageNum(int pageNum);

    int deleteBookCategoryById(int bookCategoryId);
}
