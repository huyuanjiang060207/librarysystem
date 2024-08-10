package com.hyj.projectlibrary2.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.bean.Lend;
import com.hyj.projectlibrary2.bean.User;
import com.hyj.projectlibrary2.mapper.BookMapper;
import com.hyj.projectlibrary2.mapper.LendMapper;
import com.hyj.projectlibrary2.mapper.UserMapper;
import com.hyj.projectlibrary2.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class LendServiceImpl extends ServiceImpl<LendMapper, Lend> implements LendService {
    @Autowired
    private LendMapper lendMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    public Page<Lend> userSelectByPageNum(int pageNum, HttpServletRequest request) {
        User user= (User) request.getSession().getAttribute("user");
        if(null==user){
            return null;
        }
        //查询10条数据
        List<Lend> list=lendMapper.selectByPageNumAndPageSize((pageNum-1)*10,10,user.getUserId());
        if(null==list){
            return null;
        }
        Page<Lend> page=new Page<Lend>();
        List<Lend> borrowingBooksVos=new LinkedList<>();

    }

}
