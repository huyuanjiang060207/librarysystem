package com.hyj.projectlibrary2.dao;

import com.hyj.projectlibrary2.bean.Lend;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LendDao {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    private final static String NAMESPACE = "com.hyj.projectlibrary2.dao.LendDao.";

    public int returnBookOne(final long bookid, long readerid) {
        Map<String, Object> map = new HashMap<>();
        map.put("bookid", bookid);
        map.put("readerid", readerid);
        return sqlSessionTemplate.update(NAMESPACE + "returnBookOne", map);
    }

    public int returnBookTwo(final long bookid) {
        return sqlSessionTemplate.update(NAMESPACE + "returnBookTwo", bookid);
    }

    public int lendBookOne(final long bookid, final long readerid) {
        Map<String, Object> map = new HashMap<>();
        map.put("bookid", bookid);
        map.put("readerid", readerid);
        return sqlSessionTemplate.insert(NAMESPACE + "lendBookOne", map);
    }

    public int lendBookTwo(final long bookid) {
        return sqlSessionTemplate.update(NAMESPACE + "lendBookTwo", bookid);
    }

    public ArrayList<Lend> lendList() {
        List<Lend> result = sqlSessionTemplate.selectList(NAMESPACE + "lendList");
        return (ArrayList<Lend>) result;
    }

    public ArrayList<Lend> myLendList(final long readerid) {
        List<Lend> result = sqlSessionTemplate.selectList(NAMESPACE + "myLendList", readerid);
        return (ArrayList<Lend>) result;
    }

    public int deleteLend(final long num) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteLend", num);
    }
}
