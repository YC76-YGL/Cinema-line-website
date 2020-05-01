package com.yc.clw.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.bean.ClwUser;
import com.yc.clw.bean.ClwUserExample;
import com.yc.clw.dao.ClwNewsMapper;
import com.yc.clw.dao.ClwUserMapper;

@RestController
public class ClwUserAction {

	
	@Resource
	ClwUserMapper cum;
	
	@Resource
	ClwNewsMapper cnm;
	
	@GetMapping("getusernumber")
	public List<ClwUser> getusenumber(){
		List<ClwUser> user = new ArrayList<ClwUser>();
		ClwUserExample cue = new ClwUserExample();
		cue.createCriteria().andIdIsNotNull();
		user = cum.selectByExample(cue);
		return user;
	}
	
}
