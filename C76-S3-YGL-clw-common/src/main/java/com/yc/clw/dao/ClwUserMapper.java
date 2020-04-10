package com.yc.clw.dao;

import com.yc.clw.bean.ClwUser;
import com.yc.clw.bean.ClwUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwUserMapper {
    long countByExample(ClwUserExample example);

    int deleteByExample(ClwUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwUser record);

    int insertSelective(ClwUser record);

    List<ClwUser> selectByExample(ClwUserExample example);

    ClwUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwUser record, @Param("example") ClwUserExample example);

    int updateByExample(@Param("record") ClwUser record, @Param("example") ClwUserExample example);

    int updateByPrimaryKeySelective(ClwUser record);

    int updateByPrimaryKey(ClwUser record);
}