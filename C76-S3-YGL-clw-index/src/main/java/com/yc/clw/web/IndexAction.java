package com.yc.clw.web;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.bean.ClwUser;
import com.yc.clw.biz.BizException;
import com.yc.clw.biz.UserBiz;


@RestController
@SessionAttributes("loginedUser")
public class IndexAction {

	@Resource
	IGenersAndCountryAction gaca;
	
	@Resource
	UserBiz uBiz;
	
	
	@GetMapping({"/","index","index.html"})
	public ModelAndView index(ModelAndView mav) {
		//通过远程接口方式调用信息
		mav.addObject("genlist1", gaca.lessthangetGeners());
		mav.addObject("genlist2", gaca.betweengetGeners());
		mav.addObject("genlist3", gaca.greatthangetGeners());
		mav.addObject("cce1list", gaca.lessthangetcounttry());
		mav.addObject("cce2list", gaca.betweengetcounttry());
		mav.addObject("cce3list", gaca.greaterthangetcountry());
		mav.addObject("Movielist",gaca.getfindnewmovie());
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping({"genres","genres.html"})
	public ModelAndView geners(ModelAndView mav) {
		mav.setViewName("genres");
		return mav;
	}
	@GetMapping("tologin")
	public ModelAndView tologin(ModelAndView mav) {
		mav.setViewName("Login");
		return mav;
	}
	
	@PostMapping("login")
	public ModelAndView login(ClwUser user, ModelAndView mav) {
		try {
			ClwUser dbuser = uBiz.login(user);
			// 将用户对象添加到会话
			mav.addObject("loginedUser", dbuser);
			//mav.setViewName("index");
			return index(mav);
		} catch (BizException e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.setViewName("Login");
		}
		return mav;
	}
	
	@GetMapping("toreg")
	public ModelAndView toreg(ModelAndView mav) {
		mav.setViewName("Reg");
		return mav;
	}
	
	@PostMapping("reg")
	public ModelAndView reg(ModelAndView mav,ClwUser user,String repwd) {
		try {
			uBiz.reg(user,repwd);
			mav.setViewName("Login");
		} catch (BizException e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.setViewName("Reg");
		}
		return mav;
	}
	
//	@GetMapping("logout")
//	public ModelAndView logout(ModelAndView mav) {
//		mav.setViewName("index");
//		return mav;
//	}
	
	
}
