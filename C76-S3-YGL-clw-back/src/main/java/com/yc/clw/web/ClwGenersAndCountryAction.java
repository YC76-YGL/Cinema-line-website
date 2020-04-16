package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yc.clw.bean.ClwCountry;
import com.yc.clw.bean.ClwCountryExample;
import com.yc.clw.bean.ClwGeners;
import com.yc.clw.bean.ClwGenersExample;
import com.yc.clw.bean.ClwMovielistExample;
import com.yc.clw.dao.ClwCountryMapper;
import com.yc.clw.dao.ClwGenersMapper;

@RestController
public class ClwGenersAndCountryAction {

	@Resource
	private ClwGenersMapper cgm;

	/**
	 * 影片类型
	 * 127.0.0.1:8002/lessthangetGeners
	 * @return
	 */
	@GetMapping("lessthangetGeners")
	public List<ClwGeners> lessthangetGeners(){
//		ClwMovielistExample cmle =new ClwMovielistExample();
//		cmle.setOrderByClause("id desc");
//		PageHelper.startPage(1,6);
		// -----------影片分类从数据库中查出
		ClwGenersExample cge = new ClwGenersExample();
		cge.createCriteria().andIdLessThan(7);
		List<ClwGeners> generlist =   cgm.selectByExample(cge);
		
		return generlist;
	}
	
	@GetMapping("betweengetGeners")
	public List<ClwGeners> betweengetGeners(){
		// -----------影片分类从数据库中查出
		ClwGenersExample cge = new ClwGenersExample();
		cge.createCriteria().andIdBetween(7, 12);
		List<ClwGeners> generlist =   cgm.selectByExample(cge);
		
		return generlist;
	}
	
	
	@GetMapping("greatthangetGeners")
	public List<ClwGeners> greatthangetGeners(){
		ClwGenersExample cge = new ClwGenersExample();
		cge.createCriteria().andIdGreaterThanOrEqualTo(12);
		List<ClwGeners> generlist = cgm.selectByExample(cge);
		
		return generlist;
	}
	
	
	@Resource
	private ClwCountryMapper ccMapper;
	
	@GetMapping("isnotnullgetcounttry")
	public List<ClwCountry> isnotnullgetcounttry(){
		//--------------
		ClwCountryExample cce = new ClwCountryExample();
		cce.createCriteria().andIdIsNotNull();
		 
		List<ClwCountry> ccelist = ccMapper.selectByExample(cce);
		
		return ccelist;
	}
	
	/**
	 * 影片分类国家
	 * 127.0.0.1:8002/lessthangetcounttry
	 * @return
	 */
	@GetMapping("lessthangetcounttry")
	public List<ClwCountry> lessthangetcounttry(){
		//--------------
		ClwCountryExample cce = new ClwCountryExample();
		cce.createCriteria().andIdLessThan(5);
		List<ClwCountry> ccelist = ccMapper.selectByExample(cce);
		
		return ccelist;
	}
	
	/**
	 * 影片分类国家
	 * 127.0.0.1:8002/betweengetcounttry
	 * @return
	 */
	@GetMapping("betweengetcounttry")
	public List<ClwCountry> betweengetcounttry(){
		ClwCountryExample cce = new ClwCountryExample();
		cce.createCriteria().andIdBetween(5, 8);
		List<ClwCountry> ccelist = ccMapper.selectByExample(cce);
		
		return ccelist;
	}
	
	/**
	 * 影片分类国家
	 * 127.0.0.1:8002/greaterthangetcounttry
	 * @return
	 */
	@GetMapping("greaterthangetcountry")
	public List<ClwCountry> greaterthangetcountry(){
		ClwCountryExample cce = new ClwCountryExample();
		cce.createCriteria().andIdGreaterThan(8);
		List<ClwCountry> ccelist = ccMapper.selectByExample(cce);
		
		return ccelist;
	}
	
	@GetMapping("test")
	public String test() {
		return "back test";
	}
}
