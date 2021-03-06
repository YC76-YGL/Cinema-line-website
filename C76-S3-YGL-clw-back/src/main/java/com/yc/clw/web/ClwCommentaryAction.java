package com.yc.clw.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.clw.bean.ClwCommentary;
import com.yc.clw.bean.ClwCommentaryExample;
import com.yc.clw.dao.ClwCommentaryMapper;

@RestController
public class ClwCommentaryAction {

	@Resource
	ClwCommentaryMapper ccMapper;
	
	@GetMapping("getClwCommentary")
	public List<ClwCommentary> getClwCommentary(@RequestParam("id")Integer id){
		ClwCommentaryExample cce =new ClwCommentaryExample();
		cce.createCriteria().andMovielistEqualTo(id);
		List<ClwCommentary> list = ccMapper.selectByExample(cce);
		return list;
	}
	
	@GetMapping("mycommentary")
	public List<ClwCommentary> getmycommentary(@RequestParam("id")Integer id){
		ClwCommentaryExample cce =new ClwCommentaryExample();
		cce.createCriteria().andUserEqualTo(id);
		List<ClwCommentary> list = ccMapper.selectByExample(cce);
		return list;
	}
	
	@GetMapping("MyCommentarycount")
	public Integer getMyCommentarycount(@RequestParam("userid")Integer userid) {
		ClwCommentaryExample cce =new ClwCommentaryExample();
		cce.createCriteria().andUserEqualTo(userid);
		return (int) ccMapper.countByExample(cce);
	}
	
	@GetMapping("AllUserCommentarycount")
	public Integer getAllUserCommentarycount() {
		ClwCommentaryExample cce =new ClwCommentaryExample();
		cce.createCriteria().andIdIsNotNull();
		return (int) ccMapper.countByExample(cce);
	}
}
