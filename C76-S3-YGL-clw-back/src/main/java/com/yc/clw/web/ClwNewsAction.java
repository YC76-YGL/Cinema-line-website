package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yc.clw.bean.ClwNews;
import com.yc.clw.bean.ClwNewsExample;
import com.yc.clw.dao.ClwNewsMapper;

@RestController
public class ClwNewsAction {

	@Resource
	private ClwNewsMapper cnm;
	
	@GetMapping("latestnew")
	public List<ClwNews> latestnew(){
		ClwNewsExample cne = new ClwNewsExample();
		cne.setOrderByClause(" id desc ");
		PageHelper.startPage(1, 10);
		List<ClwNews> list = cnm.selectByExample(cne);
		return list;
	}
}
