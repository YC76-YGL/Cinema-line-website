package com.yc.clw.biz;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.clw.bean.ClwCommentary;
import com.yc.clw.bean.ClwCommentaryExample;
import com.yc.clw.dao.ClwCommentaryMapper;

@Service
public class CommentaryBiz {

	@Resource
	ClwCommentaryMapper ccMapper;
	
	public String crete(ClwCommentary ccy) {
		String msg = null;
		ccy.setCreatetime(new Date());
		if(ccy.getUser() == null) {
			msg = "失败";
		}else if(ccy.getMovielist() == null) {
			msg = "失败";
		}else {
			int i = ccMapper.insert(ccy);
			if(i == 1) {
				msg = "发布成功!!!";
			}else {
				msg = "发布失败";
			}
		}
		return msg;
	}
	
	/**
	 * 根据用户编号查询本月的评论量
	 * @param userid
	 * @return
	 */
	public Integer getMyNewsthismouthCount(Integer userid) {
		ClwCommentaryExample cce = new ClwCommentaryExample();
		cce.createCriteria().andUserThismouthCommentaryEqualTo(userid);
		return (int) ccMapper.countByExample(cce);
	}
	
	/**
	 * 根据用户编号查询上月的评论量
	 * @param userid
	 * @return
	 */
	public Integer getMyNewslastmouthCount(Integer userid) {
		ClwCommentaryExample cce = new ClwCommentaryExample();
		cce.createCriteria().andUserLastmouthCommentaryEqualTo(userid);
		return (int) ccMapper.countByExample(cce);
	}
	
	
	/**
	 * 前两月评论量
	 * @param userid
	 * @return
	 */
	public Integer getFirsttwomonths(Integer userid) {
		ClwCommentaryExample cce = new ClwCommentaryExample();
		cce.createCriteria().andUserFirstmouthCommentaryEqualTo(userid);
		return (int) ccMapper.countByExample(cce);
	}
	
	
	/**
	 * 查询本月的评论量
	 * @param userid
	 * @return
	 */
	public Integer getAllUserthisCommentayCount() {
		ClwCommentaryExample cce = new ClwCommentaryExample();
		cce.createCriteria().andAllUserThisIsNotNull();
		return (int) ccMapper.countByExample(cce);
	}
	
	/**
	 * 查询上月的评论量
	 * @param userid
	 * @return
	 */
	public Integer getAllUserlastCommentayCount() {
		ClwCommentaryExample cce = new ClwCommentaryExample();
		cce.createCriteria().andAllUserLastIsNotNull();
		return (int) ccMapper.countByExample(cce);
	}
	
	
	/**
	 * 前两月评论量
	 * @param userid
	 * @return
	 */
	public Integer getAllUserFirstCommentayCount() {
		ClwCommentaryExample cce = new ClwCommentaryExample();
		cce.createCriteria().andAllUserTowlastIsNotNull();
		return (int) ccMapper.countByExample(cce);
	}
	
	
	
	
}
