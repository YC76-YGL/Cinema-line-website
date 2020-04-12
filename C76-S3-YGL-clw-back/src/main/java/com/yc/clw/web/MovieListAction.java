package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.bean.ClwGeners;
import com.yc.clw.bean.ClwGenersExample;
import com.yc.clw.dao.ClwGenersMapper;

@RestController
public class MovieListAction {
	@Resource
	private ClwGenersMapper cgm;

	/**
	 * 查询影片分类
	 * @return
	 */
	@GetMapping("getGeners")
	public List<ClwGeners> getGeners(){
		ClwGenersExample cGenersExample = new ClwGenersExample();
		cGenersExample.createCriteria().andIdEqualTo(1);
		List<ClwGeners> generlist = cgm.selectByExample(cGenersExample);
		return generlist;
	}
}
