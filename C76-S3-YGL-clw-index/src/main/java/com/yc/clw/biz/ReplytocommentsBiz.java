package com.yc.clw.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.clw.bean.ClwReplytocomments;
import com.yc.clw.dao.ClwReplytocommentsMapper;

@Service
public class ReplytocommentsBiz {

	@Resource
	ClwReplytocommentsMapper crm;
	
	
	public String CreateClwReply(ClwReplytocomments record) {
		String msg ;
		int i = crm.insert(record);
		if( i == 1) {
			msg = "发送成功,稍后会有工作人员联系您,谢谢您对反馈";
		}else {
			msg = "发送错误";
		}
		
		return msg;
	}
}
