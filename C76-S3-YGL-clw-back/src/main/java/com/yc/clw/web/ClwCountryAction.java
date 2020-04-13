package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.bean.ClwCountry;
import com.yc.clw.bean.ClwCountryExample;
import com.yc.clw.dao.ClwCountryMapper;

@RestController
public class ClwCountryAction {

	@Resource
	private ClwCountryMapper ccMapper;
	
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
}
