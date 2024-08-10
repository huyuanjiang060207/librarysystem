package com.hyj.projectlibrary2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyj.projectlibrary2.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends IService <User>{
    List<User> findUserByUserName(String userName);

    User userLogin(String userName,String password);

    User findUserById(int id);

    Page<User> findUserByPage(int pageNum);

    int insertUser(User user);

    int deleteUserById(int userId);

    boolean updateUser(User user, HttpServletRequest request);

    boolean userReturnBook(int bookId,HttpServletRequest request);

    boolean userBorrowingBook(int bookId,HttpServletRequest request);
    void lendBook(int lendid, int userid, int bookid);

    void backBook(int lendid, int userid, int bookid);
    List<User> getUserById(int id);
}
