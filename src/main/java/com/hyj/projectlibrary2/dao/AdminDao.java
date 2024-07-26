package com.hyj.projectlibrary2.dao;

import jakarta.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminDao {

    private final static String NAMESPACE = "com.hyj.projectlibrary2.dao.AdminDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    //检索数据库中管理员的数量
    public int getMatchCount(final long adminid, final String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("adminid", adminid); //添加键值对
        paramMap.put("password", password);
        return sqlSessionTemplate.selectOne(NAMESPACE + "getMatchCount", paramMap);
    }

    //重置管理员密码
    public int resetPassword(final long adminid, final String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("adminid", adminid);
        paramMap.put("password", password);
        return sqlSessionTemplate.update(NAMESPACE + "resetPassword", paramMap);
    }

    //从数据库获取管理员密码
    public String getPassword(final long adminid) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getPassword", adminid);
    }

    //从数据库获取管理员账号
    public String getUsername(final long adminid) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getUsername", adminid);
    }

}
