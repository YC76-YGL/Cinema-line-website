package com.yc.clw.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.web.IGenersAndCountryAction;

@Service
public class MergingmethoBiz {

	@Resource
	IGenersAndCountryAction gaca;
	
	public ModelAndView header(ModelAndView mav) {
		mav.addObject("genlist1", gaca.lessthangetGeners());
		mav.addObject("genlist2", gaca.betweengetGeners());
		mav.addObject("genlist3", gaca.greatthangetGeners());
		mav.addObject("cce1list", gaca.lessthangetcounttry());
		mav.addObject("cce2list", gaca.betweengetcounttry());
		mav.addObject("cce3list", gaca.greaterthangetcountry());
		return mav;
	}
	
	public ModelAndView news(ModelAndView mav) {
		header(mav);
		mav.addObject("newslist", gaca.getfindall());
		mav.addObject("latelist", gaca.latestnew());
		return mav;
	}
}
