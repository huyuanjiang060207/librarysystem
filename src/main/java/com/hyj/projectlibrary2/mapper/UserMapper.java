package com.hyj.projectlibrary2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyj.projectlibrary2.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByPageNum(@Param("currIndex") int currIndex, @Param("pageSize")int pageSize);

    int selectUserCount();

    List<User> getUserById(@Param("id") int id);
}
