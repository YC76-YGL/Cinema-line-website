package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.bean.ClwGenersExample;
import com.yc.clw.dao.ClwGenersMapper;
import com.yc.clw.dao.ClwMovielistMapper;

@RestController
public class IndexAction {

	@Resource
	private ClwMovielistMapper cml;
	
	@Resource
	private ClwGenersMapper cgm;
	
	@GetMapping({"/","index","index.html"})
	public ModelAndView index(ModelAndView mav) {
		ClwGenersExample cGenersExample = new ClwGenersExample();
		cGenersExample.createCriteria().andIdEqualTo(1);
		List<?> generlist = cgm.selectByExample(cGenersExample);
		mav.addObject("generlist",generlist);
		mav.setViewName("index");
		return mav;
	}
	
}
