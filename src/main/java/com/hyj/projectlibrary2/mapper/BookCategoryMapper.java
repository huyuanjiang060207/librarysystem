package com.hyj.projectlibrary2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyj.projectlibrary2.bean.BookCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookCategoryMapper extends BaseMapper<BookCategory> {

    int deleteByPrimaryKey(Integer categoryId);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);

    List<BookCategory> selectByPageNum(@Param("currIndex") int currIndex, @Param("pageSize")int pageSize);

    int selectAllCount();
}
