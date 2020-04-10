package com.yc.clw.dao;

import com.yc.clw.bean.ClwActor;
import com.yc.clw.bean.ClwActorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwActorMapper {
    long countByExample(ClwActorExample example);

    int deleteByExample(ClwActorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwActor record);

    int insertSelective(ClwActor record);

    List<ClwActor> selectByExample(ClwActorExample example);

    ClwActor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwActor record, @Param("example") ClwActorExample example);

    int updateByExample(@Param("record") ClwActor record, @Param("example") ClwActorExample example);

    int updateByPrimaryKeySelective(ClwActor record);

    int updateByPrimaryKey(ClwActor record);
}