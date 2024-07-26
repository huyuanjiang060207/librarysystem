package com.hyj.projectlibrary2.service;

import com.hyj.projectlibrary2.bean.Reader;
import com.hyj.projectlibrary2.dao.AdminDao;
import com.hyj.projectlibrary2.dao.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private ReaderDao readerDao;
    @Autowired
    private AdminDao adminDao;

    //检测数据库中是否含与输入对应的账户信息
    public boolean hasMatchReader(long readerId,String password){
        return  readerDao.getIdMatchCount(readerId, password)>0;
    }

    //根据id获取账号名
    public String getAdminUsername(long adminId) {
        return adminDao.getUsername(adminId);
    }

    //根据id获取读者信息
    public Reader findReaderCardByReaderId(long readerId){
        return readerDao.findReaderByReaderId(readerId);
    }

    //是否是管理员
    public boolean hasMatchAdmin(long adminId,String password){
        return adminDao.getMatchCount(adminId, password) == 1;
    }

    //管理员修改密码是否成功
    public boolean adminRePassword(long adminId, String newPassword){
        return adminDao.resetPassword(adminId,newPassword)>0;
    }

    //根据id获取管理员密码
    public String getAdminPassword(long adminId){
        return adminDao.getPassword(adminId);
    }

    //用户修改密码是否成功
    public boolean readerRePassword(long readerId, String newPassword) {
        return readerDao.resetPassword(readerId, newPassword) > 0;
    }

    //根据用户返回用户密码
    public String getReaderPassword(long readerId) {
        return readerDao.getPassword(readerId);
    }


}
