package com.yc.clw.biz;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.bean.ClwUser;
import com.yc.clw.web.IclwalltableAction;

@Service
public class MergingmethoBiz {

	@Resource
	IclwalltableAction gaca;
	
	public ModelAndView common(ModelAndView mav) {
		mav.addObject("genlist1", gaca.lessthangetGeners());
		mav.addObject("genlist2", gaca.betweengetGeners());
		mav.addObject("genlist3", gaca.greatthangetGeners());
		mav.addObject("cce1list", gaca.lessthangetcounttry());
		mav.addObject("cce2list", gaca.betweengetcounttry());
		mav.addObject("cce3list", gaca.greaterthangetcountry());
		return mav;
	}
	
	public ModelAndView newscommon(ModelAndView mav) {
		common(mav);
		mav.addObject("latelist", gaca.latestnew());
		mav.addObject("getHeadlines", gaca.getHeadlines());
		return mav;
	}
	
	
	public ModelAndView getserise(ModelAndView mav,Integer page,Integer userid) {
		common(mav);
		mav.addObject("getMostpopular", gaca.getMostpopular(page));
		mav.addObject("getcollection", gaca.getcollection(userid));
		mav.addObject("getcommentmost", gaca.getcommentmost());
		mav.addObject("page",page);
		mav.setViewName("series");
		return mav;
	}
	
	@Resource
	NewsBiz nz;
	
	@Resource
	CommentaryBiz cz;
	
	@Resource
	ClwCollectionBiz ccz;
	
	/**
	 * 普通成员
	 * @param userid
	 * @return
	 */
	public GraphtabledataBiz getusercount(Integer userid) {
		GraphtabledataBiz gtbBiz = new GraphtabledataBiz(nz.getMyNewsthismouthCount(userid),nz.getMyNewslastmouthCount(userid),nz.getFirsttwomonths(userid),
				cz.getMyNewsthismouthCount(userid),cz.getMyNewslastmouthCount(userid),cz.getFirsttwomonths(userid),
				ccz.getMyNewsthismouthCount(userid),ccz.getMyNewslastmouthCount(userid),ccz.getFirsttwomonths(userid));
		return gtbBiz;
	}
	
	
	/**
	 * 超级管理员
	 */
	public GraphtabledataBiz getallusercount() {
		GraphtabledataBiz gtbBiz = new GraphtabledataBiz(nz.getNewsthisallusernews(),nz.getNewslastallusernews(),nz.getFirstallusernews(),
				cz.getAllUserthisCommentayCount(),cz.getAllUserlastCommentayCount(),cz.getAllUserFirstCommentayCount(),
				ccz.getCollectionThismouthCount(),ccz.getCollectionLastmouthCount(),ccz.getCollectionTwomonths());
		return gtbBiz;
	}
	
	
	@Resource
	ClwCountBiz ccbz;
	
	
	public ModelAndView getinformation(ModelAndView mav,ClwUser user) {
		ClwCount cct = new ClwCount();
		cct = ccbz.getcount();
		mav.addObject("cct", cct);
		if (user.getId().equals(1)) {
			mav.addObject("getusenumber", gaca.getusenumber());
			mav.addObject("getusercount", getallusercount());
			mav.addObject("getMyCollectionCount", gaca.getAllUserCollectionCount());
			mav.addObject("getMyNewsCount", gaca.getMyNewsCount(user.getId()));
			mav.addObject("getMyCommentarycount", gaca.getAllUserCommentarycount());
			mav.setViewName("Administratormodule");
		} else {
			mav.addObject("getusenumber", user);
			mav.addObject("getusercount", getusercount(user.getId()));
			mav.addObject("getMyCollectionCount", gaca.getMyCollectionCount(user.getId()));
			mav.addObject("getMyNewsCount", gaca.getAllUserNewsCount());
			mav.addObject("getMyCommentarycount", gaca.getMyCommentarycount(user.getId()));
			mav.setViewName("Administrator");
		}
		return mav;
	}
	
}
