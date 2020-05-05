package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.bean.ClwReplytocomments;
import com.yc.clw.bean.ClwReplytocommentsExample;
import com.yc.clw.dao.ClwReplytocommentsMapper;


@RestController
public class ClwReplytocommentsAction {

	@Resource
	private ClwReplytocommentsMapper crtccMR;
	
	@GetMapping("Reply")
	public List<ClwReplytocomments> getp(){
		ClwReplytocommentsExample cExample = new ClwReplytocommentsExample();
		cExample.createCriteria().andIdEqualTo(1);
		List<ClwReplytocomments> list = crtccMR.selectByExample(cExample);
		return  list;
	}
}
