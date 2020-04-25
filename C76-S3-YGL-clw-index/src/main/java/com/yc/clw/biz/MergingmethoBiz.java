package com.yc.clw.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.web.IclwalltableAction;

@Service
public class MergingmethoBiz {

	@Resource
	IclwalltableAction gaca;
	
	public ModelAndView common(ModelAndView mav) {
		mav.addObject("genlist1", gaca.lessthangetGeners());
		mav.addObject("genlist2", gaca.betweengetGeners());
		mav.addObject("genlist3", gaca.greatthangetGeners());
		mav.addObject("cce1list", gaca.lessthangetcounttry());
		mav.addObject("cce2list", gaca.betweengetcounttry());
		mav.addObject("cce3list", gaca.greaterthangetcountry());
		return mav;
	}
	
	public ModelAndView newscommon(ModelAndView mav) {
		common(mav);
		mav.addObject("latelist", gaca.latestnew());
		mav.addObject("getHeadlines", gaca.getHeadlines());
		return mav;
	}
	
}
