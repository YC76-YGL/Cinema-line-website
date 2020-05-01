package com.yc.clw.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.clw.bean.ClwMovielistExample;
import com.yc.clw.dao.ClwMovielistMapper;

@Service
public class MovielistBiz {

	@Resource
	ClwMovielistMapper cmm;
	
	public double getgenrespage(Integer genres) {
		ClwMovielistExample cmle =new ClwMovielistExample();
		cmle.createCriteria().andGenersLike(genres.toString());
		return Math.ceil( (double)cmm.countByExample(cmle)/(double)6);
	}
	
	public double getcountrypage(Integer country) {
		ClwMovielistExample cmle =new ClwMovielistExample();
		cmle.createCriteria().andCountryEqualTo(country);
		return Math.ceil( (double)cmm.countByExample(cmle)/(double)6);
	}
	
	public double getnamepage(String name) {
		ClwMovielistExample cmle =new ClwMovielistExample();
		cmle.createCriteria().andNameLike(name);
		return Math.ceil( (double)cmm.countByExample(cmle)/(double)6);
	}
	
}
