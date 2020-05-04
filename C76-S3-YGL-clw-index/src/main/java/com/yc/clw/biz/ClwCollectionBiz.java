package com.yc.clw.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.clw.bean.ClwCollectionExample;
import com.yc.clw.dao.ClwCollectionMapper;

@Service
public class ClwCollectionBiz {

	@Resource
	ClwCollectionMapper ccr;
	
	/**
	 * 根据用户编号查询本月的新闻量
	 * @param userid
	 * @return
	 */
	public Integer getMyNewsthismouthCount(Integer userid) {
		ClwCollectionExample cce = new ClwCollectionExample();
		cce.createCriteria().andUserThismouthCollectionEqualTo(userid);
		return (int) ccr.countByExample(cce);
	}
	
	/**
	 * 根据用户编号查询上月的新闻量
	 * @param userid
	 * @return
	 */
	public Integer getMyNewslastmouthCount(Integer userid) {
		ClwCollectionExample cce = new ClwCollectionExample();
		cce.createCriteria().andUserLastmouthCollectionEqualTo(userid);
		return (int) ccr.countByExample(cce);
	}
	
	
	/**
	 * 前两月
	 * @param userid
	 * @return
	 */
	public Integer getFirsttwomonths(Integer userid) {
		ClwCollectionExample cce = new ClwCollectionExample();
		cce.createCriteria().andUserFirstmouthCollectionEqualTo(userid);
		return (int) ccr.countByExample(cce);
	}
	
	
	/**
	 * 查询本月的收藏量
	 * @param userid
	 * @return
	 */
	public Integer getCollectionThismouthCount() {
		ClwCollectionExample cce = new ClwCollectionExample();
		cce.createCriteria().andUserCollectionThisIsNotNull();
		return (int) ccr.countByExample(cce);
	}
	
	/**
	 * 查询上月的新闻量
	 * @param userid
	 * @return
	 */
	public Integer getCollectionLastmouthCount() {
		ClwCollectionExample cce = new ClwCollectionExample();
		cce.createCriteria().andUserCollectionLastIsNotNull();
		return (int) ccr.countByExample(cce);
	}
	
	
	/**
	 * 前两月新闻量
	 * @param userid
	 * @return
	 */
	public Integer getCollectionTwomonths() {
		ClwCollectionExample cce = new ClwCollectionExample();
		cce.createCriteria().andUserCollectionTwoIsNotNull();
		return (int) ccr.countByExample(cce);
	}
}
