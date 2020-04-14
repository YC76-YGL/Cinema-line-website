package com.yc.clw.biz;

import java.util.List;

import javax.annotation.Resource;

import com.yc.clw.bean.ClwUser;
import com.yc.clw.bean.ClwUserExample;
import com.yc.clw.dao.ClwUserMapper;

public class UserBiz {

	@Resource
	ClwUserMapper cum;
	
	public ClwUser login(ClwUser user) throws BizException {
		ClwUserExample cue = new ClwUserExample();
		cue.createCriteria().andUsernameEqualTo(user.getUsername())/* .andLoginnameEqualTo(user.getLoginname()) */
			.andPasswordEqualTo(user.getPassword());
		List<ClwUser> list = cum.selectByExample(cue);
		if(list.size()!=1) {
			throw new BizException("用户名或密码错误!");
		}
		return list.get(0);
	}
}
