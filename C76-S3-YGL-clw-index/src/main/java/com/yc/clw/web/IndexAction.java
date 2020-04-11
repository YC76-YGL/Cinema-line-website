package com.yc.clw.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.dao.ClwMovielistMapper;

@RestController
public class IndexAction {

	@Resource
	private ClwMovielistMapper cml;
	
	@GetMapping({"/","index","index.html"})
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
}
