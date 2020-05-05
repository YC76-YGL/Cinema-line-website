package com.yc.clw.biz;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.clw.bean.ClwReplytocomments;
import com.yc.clw.bean.ClwReplytocommentsExample;
import com.yc.clw.dao.ClwReplytocommentsMapper;
import java.text.SimpleDateFormat;

@Service
public class ReplytocommentsBiz {

	@Resource
	ClwReplytocommentsMapper crm;
	
	
	public String CreateClwReply(ClwReplytocomments record) {
		record.setCreatetime(new Date());
		String msg ;
		ClwReplytocommentsExample crExample = new ClwReplytocommentsExample();
		crExample.createCriteria().andUserEqualTo(record.getUser()).andDescribeEqualTo(record.getDescribe());
		if(crm.selectByExample(crExample) != null) {
			msg = "您已经反馈过这个问题了,稍后会有工作人员来";
		}else {
			
			int i = crm.insert(record);
			if( i == 1) {
				msg = "发送成功,稍后会有工作人员联系您,谢谢您对反馈";
			}else {
				msg = "发送错误";
			}
		}
		
		return msg;
	}
}
