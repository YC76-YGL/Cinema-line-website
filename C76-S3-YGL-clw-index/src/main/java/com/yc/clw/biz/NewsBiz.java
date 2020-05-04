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
	
	/**
	 * 根据用户编号查询本月的新闻量
	 * @param userid
	 * @return
	 */
	public Integer getMyNewsthismouthCount(Integer userid) {
		ClwNewsExample cne = new ClwNewsExample();
		cne.createCriteria().andUserThismouthnewsEqualTo(userid);
		return (int) cnm.countByExample(cne);
	}
	
	/**
	 * 根据用户编号查询上月的新闻量
	 * @param userid
	 * @return
	 */
	public Integer getMyNewslastmouthCount(Integer userid) {
		ClwNewsExample cne = new ClwNewsExample();
		cne.createCriteria().andUserLastmouthnewsEqualTo(userid);
		return (int) cnm.countByExample(cne);
	}
	
	
	/**
	 * 前两月根据用户编号
	 * @param userid
	 * @return
	 */
	public Integer getFirsttwomonths(Integer userid) {
		ClwNewsExample cne = new ClwNewsExample();
		cne.createCriteria().andUserFirstmouthnewsEqualTo(userid);
		return (int) cnm.countByExample(cne);
	}
	
	
	/**
	 * 查询本月的新闻量
	 * @param userid
	 * @return
	 */
	public Integer getNewsthisallusernews() {
		ClwNewsExample cne = new ClwNewsExample();
		cne.createCriteria().andUserUserThismouthnewsIsNotNull();
		return (int) cnm.countByExample(cne);
	}
	
	/**
	 * 查询上月的新闻量
	 * @param userid
	 * @return
	 */
	public Integer getNewslastallusernews() {
		ClwNewsExample cne = new ClwNewsExample();
		cne.createCriteria().andUserLastmouthnewsIsNotNull();
		return (int) cnm.countByExample(cne);
	}
	
	
	/**
	 * 前两月
	 * @param userid
	 * @return
	 */
	public Integer getFirstallusernews() {
		ClwNewsExample cne = new ClwNewsExample();
		cne.createCriteria().andUserFirstmouthnewsIsNotNull();
		return (int) cnm.countByExample(cne);
	}
	
	
}
