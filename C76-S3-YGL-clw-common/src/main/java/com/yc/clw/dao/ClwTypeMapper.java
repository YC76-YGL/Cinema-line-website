package com.yc.clw.dao;

import com.yc.clw.bean.ClwType;
import com.yc.clw.bean.ClwTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwTypeMapper {
    long countByExample(ClwTypeExample example);

    int deleteByExample(ClwTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwType record);

    int insertSelective(ClwType record);

    List<ClwType> selectByExample(ClwTypeExample example);

    ClwType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwType record, @Param("example") ClwTypeExample example);

    int updateByExample(@Param("record") ClwType record, @Param("example") ClwTypeExample example);

    int updateByPrimaryKeySelective(ClwType record);

    int updateByPrimaryKey(ClwType record);
}