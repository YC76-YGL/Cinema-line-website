package com.yc.clw.dao;

import com.yc.clw.bean.ClwCountry;
import com.yc.clw.bean.ClwCountryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwCountryMapper {
    long countByExample(ClwCountryExample example);

    int deleteByExample(ClwCountryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwCountry record);

    int insertSelective(ClwCountry record);

    List<ClwCountry> selectByExample(ClwCountryExample example);

    ClwCountry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwCountry record, @Param("example") ClwCountryExample example);

    int updateByExample(@Param("record") ClwCountry record, @Param("example") ClwCountryExample example);

    int updateByPrimaryKeySelective(ClwCountry record);

    int updateByPrimaryKey(ClwCountry record);
}