package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("Pressrelease")
	public int CreatePressrelease(ClwNews news){
		return cnm.insert(news);
	}
	
	/**
	 * 查询id是单数的
	 * @return
	 */
	@GetMapping("QuerySingular")
	public List<ClwNews> getQuerySingular(){
		ClwNewsExample cne = new ClwNewsExample();
		cne.setOrderByClause("createtime asc");
		cne.createCriteria().andQuerySingular();
		List<ClwNews> lsit = cnm.selectByExample(cne);
		return lsit;
	}
	
	
	/**
	 * 查询id是单数的
	 * @return
	 */
	@GetMapping("getbyidQuerySingular")
	public List<ClwNews> getbyidQuerySingular(@RequestParam("id") Integer id){
		ClwNewsExample cne = new ClwNewsExample();
		cne.setOrderByClause("createtime asc");
		cne.createCriteria().andUserEqualTo(id);
		List<ClwNews> lsit = cnm.selectByExample(cne);
		return lsit;
	}
	
	/**
	 * 查询id是双数的
	 * @return
	 */
	@GetMapping("QueryEven")
	public List<ClwNews> getQueryEven(){
		ClwNewsExample cne = new ClwNewsExample();
		cne.setOrderByClause(" RAND() ,createtime asc ");
		cne.createCriteria().andQueryEven();
		List<ClwNews> lsit = cnm.selectByExample(cne);
		return lsit;
	}
	/**
	 * 查询头条新闻
	 * @return
	 */
	@GetMapping("getHeadlines")
	public List<ClwNews> getHeadlines(){
		ClwNewsExample cne = new ClwNewsExample();
		cne.setOrderByClause("createtime asc,(watch + 0) asc");
		PageHelper.startPage(1, 10);
		List<ClwNews> lsit = cnm.selectByExample(cne);
		return lsit;
	}
	
	@GetMapping("getclwnews")
	public ClwNews getclwnews(@RequestParam("id")Integer id) {
		return cnm.selectByPrimaryKey(id);
	}
	
	@GetMapping("MyNewsCount")
	public Integer getMyNewsCount(@RequestParam("userid")Integer userid) {
		ClwNewsExample cne = new ClwNewsExample();
		cne.createCriteria().andUserEqualTo(userid);
		return (int) cnm.countByExample(cne);
	}
	
	@GetMapping("AllUserNewsCount")
	public Integer getAllUserNewsCount() {
		ClwNewsExample cne = new ClwNewsExample();
		cne.createCriteria().andIdIsNotNull();
		return (int) cnm.countByExample(cne);
	}
	
	
	
}
