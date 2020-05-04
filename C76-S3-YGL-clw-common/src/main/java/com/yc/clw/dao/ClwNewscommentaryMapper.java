package com.yc.clw.dao;

import com.yc.clw.bean.ClwNewscommentary;
import com.yc.clw.bean.ClwNewscommentaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwNewscommentaryMapper {
    long countByExample(ClwNewscommentaryExample example);

    int deleteByExample(ClwNewscommentaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwNewscommentary record);

    int insertSelective(ClwNewscommentary record);

    List<ClwNewscommentary> selectByExample(ClwNewscommentaryExample example);

    ClwNewscommentary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwNewscommentary record, @Param("example") ClwNewscommentaryExample example);

    int updateByExample(@Param("record") ClwNewscommentary record, @Param("example") ClwNewscommentaryExample example);

    int updateByPrimaryKeySelective(ClwNewscommentary record);

    int updateByPrimaryKey(ClwNewscommentary record);
}