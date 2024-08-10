package com.hyj.projectlibrary2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.bean.Lend;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface LendMapper extends BaseMapper<Lend> {

    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Lend> selectByPageNumAndPageSize(@Param("currIndex")int currIndex, @Param("pageSize")int pageSize, @Param("userId")int userId);

    int selectAllRecordCount(@Param("userId") int userId);

    List<Lend> selectAllByPage(@Param("currIndex")int currIndex,@Param("pageSize")int pageSize);

    int selectAll();

    void lendBook(int lendid, int bookid, int userid);

    void backBook(int lendid, int bookid, int userid);
}
