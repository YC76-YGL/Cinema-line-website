package com.yc.clw.biz;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.clw.bean.ClwCommentary;
import com.yc.clw.dao.ClwCommentaryMapper;

@Service
public class CommentaryBiz {

	@Resource
	ClwCommentaryMapper ccMapper;
	
	public String crete(ClwCommentary ccy) {
		String msg = null;
		ccy.setCreatetime(new Date());
		int i = ccMapper.insert(ccy);
		if(i == 1) {
			msg = "发布成功!!!";
		}else {
			msg = "发布失败";
		}
		return msg;
	}
}
