package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.bean.ClwCollection;
import com.yc.clw.bean.ClwCollectionExample;
import com.yc.clw.dao.ClwCollectionMapper;

@RestController
public class ClwCollectionAction {
	
	@Resource
	ClwCollectionMapper ccMapper;
	
	@GetMapping("getcollection")
	public List<ClwCollection> getcollection(@RequestParam("id")Integer userid){
		ClwCollectionExample ccExample = new ClwCollectionExample();
		ccExample.createCriteria().andUserEqualTo(userid);
		ccExample.setOrderByClause(" id desc ");
		List<ClwCollection> lsit  = ccMapper.selectByExample(ccExample);
		
		return lsit;
	}
	
	@GetMapping("MyCollectionCount")
	public Integer getMyCollectionCount(@RequestParam("userid")Integer userid) {
		ClwCollectionExample ccExample = new ClwCollectionExample();
		ccExample.createCriteria().andUserEqualTo(userid);
		return (int) ccMapper.countByExample(ccExample);
	}
	
	@GetMapping("AllUserCollectionCount")
	public Integer getAllUserCollectionCount() {
		ClwCollectionExample ccExample = new ClwCollectionExample();
		ccExample.createCriteria().andIdIsNotNull();
		return (int) ccMapper.countByExample(ccExample);
	}

}
