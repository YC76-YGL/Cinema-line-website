package com.yc.clw.dao;

import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwMovielistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwMovielistMapper {
    long countByExample(ClwMovielistExample example);

    int deleteByExample(ClwMovielistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwMovielist record);

    int insertSelective(ClwMovielist record);

    List<ClwMovielist> selectByExample(ClwMovielistExample example);

    ClwMovielist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwMovielist record, @Param("example") ClwMovielistExample example);

    int updateByExample(@Param("record") ClwMovielist record, @Param("example") ClwMovielistExample example);

    int updateByPrimaryKeySelective(ClwMovielist record);

    int updateByPrimaryKey(ClwMovielist record);
}