package com.yc.clw.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.dao.ClwMovielistMapper;

@RestController
public class ClwMovieListAction {

	@Resource
	private ClwMovielistMapper cmlm;
	
}
