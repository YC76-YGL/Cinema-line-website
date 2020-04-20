package com.yc.clw.web;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwUser;
import com.yc.clw.biz.BizException;
import com.yc.clw.biz.MergingmethoBiz;
import com.yc.clw.biz.UserBiz;


@RestController
@SessionAttributes("loginedUser")
public class IndexAction {

	@Resource
	IclwalltableAction gaca;
	
	@Resource
	UserBiz uBiz;
	
	@Resource
	MergingmethoBiz mmb;
	
	@GetMapping({"/","index","index.html"})
	public ModelAndView index(ModelAndView mav) {
		//通过远程接口方式调用信息
		mmb.header(mav);
		mav.addObject("Movielist",gaca.getnewmovie());
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("genres")
	public ModelAndView geners(@RequestParam("id")Integer id,ModelAndView mav) {
		if(id.equals(0)) {
			mav.setViewName("Error");
		}else {
			mmb.header(mav);
			mav.addObject("getmovie", gaca.getgenresmovie(id));
			mav.setViewName("genres");
		}
		return mav;
	}
	
	@GetMapping("country")
	public ModelAndView country(@RequestParam("id")Integer id,ModelAndView mav) {
		if(id.equals(0)) {
			mav.setViewName("Error");
		}else {
			mmb.header(mav);
			mav.addObject("getmovie", gaca.getcountrmovie(id));
			mav.setViewName("genres");
		}
		return mav;
	}
	
	@GetMapping("tologin")
	public ModelAndView tologin(ModelAndView mav) {
		mav.setViewName("Login");
		return mav;
	}
	
	@GetMapping("Administrator")
	public ModelAndView Administrator(ModelAndView mav) {
		mav.setViewName("Administrator");
		return mav;
	}
	
	@PostMapping("login")
	public ModelAndView login(ClwUser user, ModelAndView mav) {
		try {
			ClwUser dbuser = uBiz.login(user);
			// 将用户对象添加到会话
			mav.addObject("loginedUser", dbuser);
			mmb.header(mav);
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
	
	@GetMapping("logout")
	public ModelAndView logout(ModelAndView mav) {
		mav.clear();
		mav.setViewName("index");
		return mav;
	}
	
	
	@GetMapping("new")
	public ModelAndView news(ModelAndView mav) {
		mmb.news(mav);
		mav.setViewName("news");
		return mav;
	}
	
	@GetMapping("newsingle")
	public ModelAndView newsingle(@RequestParam("id")Integer id,ModelAndView mav) {
		if(id == 0) {
			mav.setViewName("Error");
		}else {
			mmb.header(mav);
			mav.addObject("getclwnews", gaca.getclwnews(id));
			mav.addObject("leatestlist", gaca.latestnew());
			mav.addObject("latelist", gaca.latestnew());
			mav.setViewName("news-single");
		}
		return mav;
	}
	
	
	@GetMapping("allgenres")
	public ModelAndView allgenres(ModelAndView mav) {
		return mav;
	}
	
	@GetMapping("single")
	public ModelAndView single(@RequestParam("id")Integer id,ModelAndView mav) {
		if(id == 0) {
			mav.setViewName("Error");
		}else {
			List<ClwMovielist> list = gaca.getidmovie(id);
			if(list != null) {
				mmb.header(mav);
				mav.addObject("getclwnews", list);
				mav.addObject("getClwCommentarylist", gaca.getClwCommentary(id));
				mav.setViewName("single");
			}
		}
		return mav;
	}
	
	@GetMapping("list")
	public ModelAndView list(ModelAndView mav) {
		mmb.header(mav);
		mav.setViewName("list");
		return mav;
	}
	
}
