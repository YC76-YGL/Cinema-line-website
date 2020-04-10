package com.yc.clw.dao;

import com.yc.clw.bean.ClwCommentary;
import com.yc.clw.bean.ClwCommentaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwCommentaryMapper {
    long countByExample(ClwCommentaryExample example);

    int deleteByExample(ClwCommentaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwCommentary record);

    int insertSelective(ClwCommentary record);

    List<ClwCommentary> selectByExample(ClwCommentaryExample example);

    ClwCommentary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwCommentary record, @Param("example") ClwCommentaryExample example);

    int updateByExample(@Param("record") ClwCommentary record, @Param("example") ClwCommentaryExample example);

    int updateByPrimaryKeySelective(ClwCommentary record);

    int updateByPrimaryKey(ClwCommentary record);
}