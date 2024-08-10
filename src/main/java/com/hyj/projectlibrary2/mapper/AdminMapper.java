package com.hyj.projectlibrary2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyj.projectlibrary2.bean.Admin;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

}
