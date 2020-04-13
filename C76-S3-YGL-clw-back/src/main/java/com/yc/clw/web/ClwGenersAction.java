package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.bean.ClwGeners;
import com.yc.clw.bean.ClwGenersExample;
import com.yc.clw.dao.ClwGenersMapper;

@RestController
public class ClwGenersAction {
	@Resource
	private ClwGenersMapper cgm;

	/**
	 * 影片类型
	 * 127.0.0.1:8002/lessthangetGeners
	 * @return
	 */
	@GetMapping("lessthangetGeners")
	public List<ClwGeners> lessthangetGeners(){
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
}
