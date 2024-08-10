package com.hyj.projectlibrary2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.bean.Lend;

import javax.servlet.http.HttpServletRequest;

public interface LendService extends IService<Lend> {
    Book lendBook(int lendId, int bookid, int userid);
    void backBook(int lendId, int bookid, int userid);
    public Page<Lend> userSelectByPageNum(int pageNum, HttpServletRequest request);
    public Page<Lend> selectAllByPage(int pageNum);
}
