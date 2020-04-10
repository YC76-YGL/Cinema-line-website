package com.yc.clw.dao;

import com.yc.clw.bean.ClwGeners;
import com.yc.clw.bean.ClwGenersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwGenersMapper {
    long countByExample(ClwGenersExample example);

    int deleteByExample(ClwGenersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwGeners record);

    int insertSelective(ClwGeners record);

    List<ClwGeners> selectByExample(ClwGenersExample example);

    ClwGeners selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwGeners record, @Param("example") ClwGenersExample example);

    int updateByExample(@Param("record") ClwGeners record, @Param("example") ClwGenersExample example);

    int updateByPrimaryKeySelective(ClwGeners record);

    int updateByPrimaryKey(ClwGeners record);
}