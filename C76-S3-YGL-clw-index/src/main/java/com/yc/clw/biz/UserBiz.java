package com.yc.clw.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.clw.bean.ClwUser;
import com.yc.clw.bean.ClwUserExample;
import com.yc.clw.dao.ClwUserMapper;

@Service
public class UserBiz {

	@Resource
	ClwUserMapper cum;

	public ClwUser login(ClwUser user) throws BizException {
		ClwUserExample cue = new ClwUserExample();
		cue.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<ClwUser> list = cum.selectByExample(cue);
		if (list.size() != 1) {
			throw new BizException("用户名或密码错误!");
		}
		return list.get(0);
	}

	public void reg(ClwUser user, String repwd) throws BizException {
		ClwUserExample cue = new ClwUserExample();
		cue.createCriteria().andUsernameEqualTo(user.getUsername());

		if (user.getPassword().equals(repwd) == false) {
			throw new BizException("密码不一致");
		}

		if (cum.countByExample(cue) > 0) {
			throw new BizException("该用户名已经被注册");
		}
		user.setType("3");
		cum.insert(user);
	}

	@Resource
	private MailService ms;

	public String forget(String email) throws BizException {
		if (email != null) {
			String vcode = System.currentTimeMillis() + "";
			vcode = vcode.substring(vcode.length() - 4, vcode.length());
			String content = "您重置密码所需的验证码是: " + vcode;
			ms.sendSimpleMail(email, "重置密码", content);
			return vcode;
		} else {
			throw new BizException("该用户名错误");
		}
	}
	
	public String updatepassword(ClwUser user) throws BizException {
		String msg = "修改成功";
		ClwUserExample cue = new ClwUserExample();
		cue.createCriteria().andIdEqualTo(user.getId());
		cum.updateByExampleSelective(user, cue);
		return msg;
	}
	
	public String updatelookpath(ClwUser user) throws BizException {
		String msg="";
		ClwUserExample cue1 = new ClwUserExample();
		cue1.createCriteria().andLookEqualTo(user.getLook());
		List<ClwUser> list = cum.selectByExample(cue1);
		if (list.size() != 1) {
			ClwUserExample cue = new ClwUserExample();
			cue.createCriteria().andIdEqualTo(user.getId());
			cum.updateByExampleSelective(user, cue);
			msg = "修改成功";
		}else {
			System.out.println(list);
			msg="请换个文件名";
		}
		return msg;
	}
	
}
