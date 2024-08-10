package com.hyj.projectlibrary2.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.mapper.BookMapper;
import com.hyj.projectlibrary2.mapper.LendMapper;
import com.hyj.projectlibrary2.mapper.UserMapper;
import com.hyj.projectlibrary2.bean.User;
import com.hyj.projectlibrary2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LendMapper lendMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void lendBook(int lendid, int userid, int bookid) {
        Date borrowDate = new Date(); // 获取当前系统时间
        lendMapper.lendBook(lendid, bookid, userid);
    }

    @Override
    public void backBook(int lendid, int userid, int bookid) {
        Date returnDate = new Date(); // 获取当前系统时间
        lendMapper.backBook(lendid, bookid, userid);
    }


    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void lendBook(int lendid, String userid, int bookid) {
        Date lendDate = new Date(); // 获取当前系统时间
        lendMapper.lendBook(lendid, bookid, Integer.parseInt(userid));
    }

    @Override
    public void backBook(int lendid, String userid, int bookid) {
        Date backDate = new Date(); // 获取当前系统时间
        lendMapper.backBook(lendid, bookid, Integer.parseInt(userid));
    }

    @Override
    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<User> findUserByPage(int pageNum) {
        List<User> users=userMapper.selectByPageNum((pageNum-1)*10,10);
        Page<User> page=new Page<>();
        page.setList(users);
        page.setPageNum(pageNum);
        page.setPageSize(10);

        int userCount=userMapper.selectUserCount();
        int pageCount=userCount/10;
        if(userCount%10!=0){
            pageCount++;
        }
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public boolean updateUser(User user, HttpServletRequest request) {
        //获取session对象中user对象
        User sessionUser= (User) request.getSession().getAttribute("user");
        user.setUserId(sessionUser.getUserId());
        int n=userMapper.updateByPrimaryKey(user);
        if(n>0){
            //修改成功，更新session对象
            User newUser=userMapper.selectByPrimaryKey(user.getUserId());
            request.getSession().setAttribute("user",newUser);
            return true;
        }
        return false;
    }
}
