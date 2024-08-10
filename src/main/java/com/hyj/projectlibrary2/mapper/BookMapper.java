package com.hyj.projectlibrary2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyj.projectlibrary2.bean.Book;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookMapper extends BaseMapper<Book> {

    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    //按书籍种类分页查找
    List<Book> selectByCategoryId(@Param("categoryId")int categoryId,@Param("currIndex") int currIndex,@Param("pageSize") int PageSize);

    //查找某一类别书籍的总数
    int selectBookCountByCategoryId(@Param("categoryId")int categoryId);
}
