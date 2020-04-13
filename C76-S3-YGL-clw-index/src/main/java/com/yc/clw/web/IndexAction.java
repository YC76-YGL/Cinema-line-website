package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.bean.ClwCountry;
import com.yc.clw.bean.ClwCountryExample;
import com.yc.clw.bean.ClwGeners;
import com.yc.clw.bean.ClwGenersExample;
import com.yc.clw.dao.ClwCountryMapper;
import com.yc.clw.dao.ClwGenersMapper;
import com.yc.clw.dao.ClwMovielistMapper;

@RestController
public class IndexAction {

	@Resource
	private ClwMovielistMapper cml;
	
	@Resource
	private ClwGenersMapper clwGenermapper;
	
	@Resource
	private ClwCountryMapper clwcountrymapper;
	
	/*
	 * @Resource IGenerAction igaAction;
	 */
	@GetMapping({"/","index","index.html"})
	public ModelAndView index(ModelAndView mav) {
		// -----------影片分类从数据库中查出
		ClwGenersExample cge1 = new ClwGenersExample();
		cge1.createCriteria().andIdLessThan(7);
		List<ClwGeners> genlist1 =   clwGenermapper.selectByExample(cge1);
		mav.addObject("genlist1", genlist1);
		
		ClwGenersExample cge2 = new ClwGenersExample();
		cge2.createCriteria().andIdBetween(7, 12);
		List<ClwGeners> genlist2 =   clwGenermapper.selectByExample(cge2);
		mav.addObject("genlist2", genlist2);
		
		ClwGenersExample cge3 = new ClwGenersExample();
		cge3.createCriteria().andIdGreaterThanOrEqualTo(12);
		List<ClwGeners> genlist3 =   clwGenermapper.selectByExample(cge3);
		mav.addObject("genlist3", genlist3);
		//--------------某国电影
		ClwCountryExample cce1 = new ClwCountryExample();
		cce1.createCriteria().andIdLessThan(5);
		List<ClwCountry> cce1list = clwcountrymapper.selectByExample(cce1);
		mav.addObject("cce1list", cce1list);
		
		ClwCountryExample cce2 = new ClwCountryExample();
		cce2.createCriteria().andIdBetween(5, 8);
		List<ClwCountry> cce2list = clwcountrymapper.selectByExample(cce2);
		mav.addObject("cce2list", cce2list);
		
		ClwCountryExample cce3 = new ClwCountryExample();
		cce3.createCriteria().andIdGreaterThan(8);
		List<ClwCountry> cce3list = clwcountrymapper.selectByExample(cce3);
		mav.addObject("cce3list", cce3list);
		
		//通过远程接口方式调用信息
		/* mav.addObject("generlist",igaAction.getGeners()); */
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
