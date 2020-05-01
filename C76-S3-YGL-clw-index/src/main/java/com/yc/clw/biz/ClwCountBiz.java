package com.yc.clw.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.clw.bean.ClwGenersExample;
import com.yc.clw.bean.ClwMovielistExample;
import com.yc.clw.bean.ClwNewsExample;
import com.yc.clw.bean.ClwUserExample;
import com.yc.clw.dao.ClwGenersMapper;
import com.yc.clw.dao.ClwMovielistMapper;
import com.yc.clw.dao.ClwNewsMapper;
import com.yc.clw.dao.ClwUserMapper;

@Service
public class ClwCountBiz {

	@Resource
	ClwUserMapper cum;

	@Resource
	ClwMovielistMapper cmm;

	@Resource
	ClwNewsMapper cnm;
	
	@Resource
	ClwGenersMapper cgm;

	public ClwCount getcount() {
		ClwCount ccClwCount = new ClwCount();
		ClwUserExample cue = new ClwUserExample();
		cue.createCriteria().andIdIsNotNull();
		ccClwCount.setUser((int) cum.countByExample(cue));

		ClwMovielistExample cMovielistExample = new ClwMovielistExample();
		cMovielistExample.createCriteria().andIdIsNotNull();
		ccClwCount.setMovie((int) cmm.countByExample(cMovielistExample));

		ClwNewsExample cNewsExample = new ClwNewsExample();
		cNewsExample.createCriteria().andIdIsNotNull();
		ccClwCount.setNews((int) cnm.countByExample(cNewsExample));
		
		ClwGenersExample cge = new ClwGenersExample();
		cge.createCriteria().andIdIsNotNull();
		ccClwCount.setGenres((int) cgm.countByExample(cge));

		return ccClwCount;
	}
}
