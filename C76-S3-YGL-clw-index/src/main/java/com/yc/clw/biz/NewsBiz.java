package com.yc.clw.biz;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yc.clw.bean.ClwNews;
import com.yc.clw.bean.ClwNewsExample;
import com.yc.clw.dao.ClwNewsMapper;

@Service
public class NewsBiz {

	@Resource
	ClwNewsMapper cnm;
	
	public String create(ClwNews clwnews) throws BizException{
		String msg;
		ClwNewsExample cNewsExample = new ClwNewsExample();
		cNewsExample.createCriteria().andTitleEqualTo(clwnews.getTitle());
		if(cnm.countByExample(cNewsExample) > 0)
		{
			msg = "该文章已经被创建";
		}
		
		cnm.insert(clwnews);
		msg = "创建成功";
		return msg;
	}
	
	public List<ClwNews> alike(Integer user,Integer id){
		ClwNewsExample cne = new ClwNewsExample();
		cne.setOrderByClause("createtime asc");
		cne.createCriteria().andIdNotEqualTo(id).andUserEqualTo(user);
		PageHelper.startPage(1, 2);
		List<ClwNews> list = cnm.selectByExample(cne);
		return list;
	}
	
	
}
