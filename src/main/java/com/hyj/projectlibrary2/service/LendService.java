package com.hyj.projectlibrary2.service;

import com.hyj.projectlibrary2.bean.Lend;
import com.hyj.projectlibrary2.dao.LendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LendService {
    @Autowired
    private LendDao lendDao;

    public boolean returnBook(long bookid, long readerid){
        return lendDao.returnBookOne(bookid, readerid)>0 && lendDao.returnBookTwo(bookid)>0;
    }

    public boolean lendBook(long bookid,long readerid){
        return lendDao.lendBookOne(bookid,readerid)>0 && lendDao.lendBookTwo(bookid)>0;
    }

    public ArrayList<Lend> lendList(){
        return lendDao.lendList();
    }
    public ArrayList<Lend> myLendList(long readerid){
        return lendDao.myLendList(readerid);
    }

    public int deleteLend(long num) {
        return lendDao.deleteLend(num);
    }

}
