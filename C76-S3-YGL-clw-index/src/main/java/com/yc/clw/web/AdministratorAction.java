package com.yc.clw.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdministratorAction {

	@GetMapping("admin")
	public ModelAndView getadmin(ModelAndView mav) {
		mav.setViewName("Administrator");
		return mav;
	}
}
