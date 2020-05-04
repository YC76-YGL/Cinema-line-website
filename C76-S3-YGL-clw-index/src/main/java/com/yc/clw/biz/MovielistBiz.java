package com.yc.clw.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yc.clw.bean.ClwMovielist;
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
	
	public double getpage() {
		ClwMovielistExample cMovielistExample = new ClwMovielistExample();
		cMovielistExample.createCriteria().andIdIsNotNull();
		return Math.ceil( (double)cmm.countByExample(cMovielistExample)/(double)10);
	}
	
	public List<ClwMovielist> getalikemovie(Integer counttrry,Integer id){
		List<ClwMovielist> list =new ArrayList<>();
		ClwMovielistExample cMovielistExample = new ClwMovielistExample();
		cMovielistExample.createCriteria().andCountryEqualTo(counttrry).andIdNotEqualTo(id);
		cMovielistExample.setOrderByClause(" createtime asc ");
		PageHelper.startPage(1, 6);
		list = cmm.selectByExample(cMovielistExample);
		return list;
	}
	
	public String update(ClwMovielist list) {
		String msg;
		int i = cmm.updateByPrimaryKey(list);
		if(i == 1) {
			msg = "成功";
		}else {
			msg = "失败";
		}
		return msg;
	}
	
	public String add(ClwMovielist list) {
		String msg;
		list.setCreatetime(new Date());
		int i = cmm.insert(list);
		if(i == 1) {
			msg = "成功";
		}else {
			msg = "失败";
		}
		return msg;
	}
	
}
