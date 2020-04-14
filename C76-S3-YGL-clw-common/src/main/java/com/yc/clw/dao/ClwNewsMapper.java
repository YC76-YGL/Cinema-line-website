package com.yc.clw.dao;

import com.yc.clw.bean.ClwNews;
import com.yc.clw.bean.ClwNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwNewsMapper {
    long countByExample(ClwNewsExample example);

    int deleteByExample(ClwNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwNews record);

    int insertSelective(ClwNews record);

    List<ClwNews> selectByExample(ClwNewsExample example);

    ClwNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwNews record, @Param("example") ClwNewsExample example);

    int updateByExample(@Param("record") ClwNews record, @Param("example") ClwNewsExample example);

    int updateByPrimaryKeySelective(ClwNews record);

    int updateByPrimaryKey(ClwNews record);
}