package com.yc.clw.web;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.bean.ClwUser;
import com.yc.clw.biz.BizException;
import com.yc.clw.biz.UserBiz;


@RestController
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
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping({"gener","gener.html"})
	public ModelAndView geners(ModelAndView mav) {
		mav.setViewName("gener");
		return mav;
	}
	
	@GetMapping("tologin")
	public ModelAndView tologin(ModelAndView mav) {
		mav.setViewName("Login");
		return mav;
	}
	
	@PostMapping("login")
	public ModelAndView login(ClwUser user, ModelAndView mav, 
			@SessionAttribute(name="uri",required=false) String uri,
			HttpSession session) {
		try {
			ClwUser dbuser = uBiz.login(user);
			/**
			 * 	屏蔽之前的写法
				// 将用户对象添加到会话
				mav.addObject("loginedUser", dbuser);
				
			 * 	响应重定向添加会话属性, 使用
			 * 		mav.addObject("loginedUser", dbuser);
			 * 	会出现会话属性添加失败的问题, 所以改成下面的写法
			 */
			session.setAttribute("loginedUser", dbuser);
			if(uri != null) {
				// 这是拦截登录的情况
				mav.setViewName("redirect:http://127.0.0.1" + uri);
			} else {
				// 这是用户的主动登录
				mav.setViewName("index");
			}
			return index(mav);
		} catch (BizException e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.setViewName("Login");
		}
		return mav;
	}
	
	
	
	
}
