package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwMovielistExample;
import com.yc.clw.dao.ClwMovielistMapper;

@RestController
public class ClwMovieListAction {

	@Resource
	private ClwMovielistMapper cmlm;
	
	@GetMapping("getClwMovielist")
	public List<ClwMovielist> getClwMovielist(){
		ClwMovielistExample cmle =new ClwMovielistExample();
		cmle.createCriteria().andIdIsNotNull();
		List<ClwMovielist> list = cmlm.selectByExample(cmle);
		return list;
	}
	
}
