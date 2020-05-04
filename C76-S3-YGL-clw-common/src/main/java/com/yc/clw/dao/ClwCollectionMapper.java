package com.yc.clw.dao;

import com.yc.clw.bean.ClwCollection;
import com.yc.clw.bean.ClwCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwCollectionMapper {
    long countByExample(ClwCollectionExample example);

    int deleteByExample(ClwCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwCollection record);

    int insertSelective(ClwCollection record);

    List<ClwCollection> selectByExample(ClwCollectionExample example);

    ClwCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwCollection record, @Param("example") ClwCollectionExample example);

    int updateByExample(@Param("record") ClwCollection record, @Param("example") ClwCollectionExample example);

    int updateByPrimaryKeySelective(ClwCollection record);

    int updateByPrimaryKey(ClwCollection record);
}