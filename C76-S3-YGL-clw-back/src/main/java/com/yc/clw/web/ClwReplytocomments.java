package com.yc.clw.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.dao.ClwReplytocommentsMapper;


@RestController
public class ClwReplytocomments {

	@Resource
	private ClwReplytocommentsMapper crtccMR;
	
	
	
}
