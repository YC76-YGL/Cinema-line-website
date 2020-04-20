package com.yc.clw.dao;

import com.yc.clw.bean.ClwReplytocomments;
import com.yc.clw.bean.ClwReplytocommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClwReplytocommentsMapper {
    long countByExample(ClwReplytocommentsExample example);

    int deleteByExample(ClwReplytocommentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClwReplytocomments record);

    int insertSelective(ClwReplytocomments record);

    List<ClwReplytocomments> selectByExample(ClwReplytocommentsExample example);

    ClwReplytocomments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClwReplytocomments record, @Param("example") ClwReplytocommentsExample example);

    int updateByExample(@Param("record") ClwReplytocomments record, @Param("example") ClwReplytocommentsExample example);

    int updateByPrimaryKeySelective(ClwReplytocomments record);

    int updateByPrimaryKey(ClwReplytocomments record);
}