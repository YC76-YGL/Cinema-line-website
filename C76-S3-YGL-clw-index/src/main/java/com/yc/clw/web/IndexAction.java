package com.yc.clw.web;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class IndexAction {

	@Resource
	IGenersAndCountryAction gaca;
	
	/*
	 * @Resource IGenerAction igaAction;
	 */
	@GetMapping({"/","index","index.html"})
	public ModelAndView index(ModelAndView mav) {
		//通过远程接口方式调用信息
		mav.addObject("genlist1", gaca.lessthangetGeners());
		mav.addObject("genlist2", gaca.betweengetGeners());
		mav.addObject("genlist3", gaca.greatthangetGeners());
		mav.addObject("cce1list", gaca.lessthangetcounttry());
		mav.addObject("cce2list", gaca.betweengetcounttry());
		mav.addObject("cce3list", gaca.greaterthangetcountry());
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping({"gener","gener.html"})
	public ModelAndView geners(ModelAndView mav) {
		mav.setViewName("gener");
		return mav;
	}
	
	@GetMapping({"list","list.html"})
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("list");
		return mav;
	}
	
	@GetMapping({"news","news.html"})
	public ModelAndView news(ModelAndView mav) {
		mav.setViewName("news");
		return mav;
	}
	
}
