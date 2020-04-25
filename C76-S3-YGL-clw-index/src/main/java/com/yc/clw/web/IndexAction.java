package com.yc.clw.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwNews;
import com.yc.clw.bean.ClwUser;
import com.yc.clw.bean.ClwgenresidAndpage;
import com.yc.clw.biz.BizException;
import com.yc.clw.biz.MergingmethoBiz;
import com.yc.clw.biz.NewsBiz;
import com.yc.clw.biz.UserBiz;

@RestController
@SessionAttributes({ "loginedUser", "genresid" })
//@EnableScheduling
public class IndexAction {

	@Resource
	IclwalltableAction gaca;

	@Resource
	UserBiz uBiz;

	@Resource
	MergingmethoBiz mmb;

	@GetMapping({ "/", "index", "index.html" })
	public ModelAndView index(ModelAndView mav) {
		// 通过远程接口方式调用信息
		mmb.common(mav);
		mav.addObject("getgareaterratmovie", gaca.getgareaterratmovie());
		mav.addObject("getnewmovie", gaca.getnewmovie());
		mav.addObject("getMostpopular", gaca.getMostpopular());
		mav.setViewName("index");
		return mav;
	}

	@GetMapping("genres")
	public ModelAndView geners(@RequestParam(defaultValue = "1") Integer page, @RequestParam("id") Integer id,
			ModelAndView mav, ClwgenresidAndpage cgap) {
		mmb.common(mav);
		if (id != 0) {
			cgap.setId(id);
			cgap.setPage(page);
			mav.addObject("getmovie", gaca.getgenresmovie(page, id));
		}else {
			cgap.setPage(page);
			mav.addObject("getmovie", gaca.getallgenresmovie(page));
		}
		mav.addObject("genresid", cgap);
		mav.setViewName("genres");
		return mav;
	}

	@GetMapping("country")
	public ModelAndView country(@RequestParam(defaultValue = "1") Integer page, @RequestParam("id") Integer id,
			ModelAndView mav, ClwgenresidAndpage cgap) {
		if (id.equals(0)) {
			mav.setViewName("Error");
		} else {
			mmb.common(mav);
			cgap.setId(id);
			cgap.setPage(page);
			mav.addObject("genresid", cgap);
			mav.addObject("getmovie", gaca.getcountrmovie(id));
			mav.setViewName("genres");
		}
		return mav;
	}

	@GetMapping("tologin")
	public ModelAndView tologin(ModelAndView mav) {
		mav.setViewName("Login");
		return mav;
	}

	@PostMapping("login")
	public ModelAndView login(ClwUser user, ModelAndView mav,
			@SessionAttribute(name = "uri", required = false) String uri) {
		try {
			ClwUser dbuser = uBiz.login(user);
			// 将用户对象添加到会话
			mav.addObject("loginedUser", dbuser);
			mmb.common(mav);
			if (uri != null) {
				mav.setViewName("redirect:" + uri);
			} else {
				mav.setViewName("index");
			}
		} catch (BizException e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.setViewName("Login");
		}
		return mav;
	}
//	@Scheduled(cron = "0 0/1 * * * ?" )
//	public ModelAndView Scheduledtasks(ModelAndView mav) {
//		mav.setViewName("lock-screen");
//		return mav;
//	}

	@GetMapping("toreg")
	public ModelAndView toreg(ModelAndView mav) {
		mav.setViewName("Reg");
		return mav;
	}

	@PostMapping("reg")
	public ModelAndView reg(ModelAndView mav, ClwUser user, String repwd) {
		try {
			uBiz.reg(user, repwd);
			mav.setViewName("Login");
		} catch (BizException e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.setViewName("Reg");
		}
		return mav;
	}

	@GetMapping("logout")
	public ModelAndView logout(ModelAndView mav) {
		mav.clear();
		mav.setViewName("index");
		return mav;
	}

	@GetMapping("new")
	public ModelAndView news(ModelAndView mav) {
		mmb.newscommon(mav);
		mav.addObject("getQuerySingular", gaca.getQuerySingular());
		mav.setViewName("news");
		return mav;
	}

	@GetMapping("newsingle")
	public ModelAndView newsingle(@RequestParam("id") Integer id, ModelAndView mav) {
		if (id == 0) {
			mav.setViewName("Error");
		} else {
			mmb.newscommon(mav);
			mav.addObject("getclwnews", gaca.getclwnews(id));
			mav.setViewName("news-single");
		}
		return mav;
	}

	@GetMapping("single")
	public ModelAndView single(@RequestParam("id") Integer id, ModelAndView mav) {
		if (id == 0) {
			mav.setViewName("Error");
		} else {
			List<ClwMovielist> list = gaca.getidmovie(id);
			if (list != null) {
				mmb.common(mav);
				mav.addObject("getidmovie", list);
				mav.addObject("getClwCommentarylist", gaca.getClwCommentary(id));
				mav.setViewName("single");
			}
		}
		return mav;
	}

	@GetMapping("list")
	public ModelAndView list(ModelAndView mav) {
		mmb.common(mav);
		mav.setViewName("list");
		return mav;
	}
	
	@GetMapping("admin")
	public ModelAndView getadmin(ModelAndView mav,@SessionAttribute("loginedUser") ClwUser user) {
		if(user == null) {
			mav.setViewName("login");
		}else {
			mav.setViewName("Administrator");
		}
		return mav;
	}

	
	@GetMapping("user_basic")
	public ModelAndView getuser_basic(ModelAndView mav) {
		mav.setViewName("back-stagemanagement/user_basic");
		return mav;
	}
	
	@GetMapping("typography")
	public ModelAndView gettypography(@RequestParam("id") Integer id,ModelAndView mav) {
		mav.addObject("getbyidQuerySingular", gaca.getbyidQuerySingular(id));
		mav.setViewName("back-stagemanagement/typography");
		return mav;
	}
	
	@GetMapping("Modifypersonalinformation")
	public ModelAndView getModifypersonalinformation(ModelAndView mav) {
		mav.setViewName("back-stagemanagement/ChangePassword");
		return mav;
	}
	
	@GetMapping("Pressrelease")
	public ModelAndView getPressrelease(ModelAndView mav) {
		mav.setViewName("back-stagemanagement/Pressrelease");
		return mav;
	}
	
	@Value("${myUploadPath}")
	private String myUploadPath;
	
	@Resource
	NewsBiz nb;
	
	@PostMapping("Createnews")
	public ModelAndView getCreatenews(ClwNews news,@RequestParam("file") MultipartFile file,ModelAndView mav) {
		try {
			file.transferTo(new File(myUploadPath + file.getOriginalFilename()));
			// 定义用户头像的图片的 web 路径
			String head = "sjkimage/" + file.getOriginalFilename();
			news.setOther(head);
			news.setCreatetime(new Date());
			nb.create(news);
			mav.setViewName("back-stagemanagement/Pressrelease");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("Error");
		}
		return mav;
	}
	
	@GetMapping("mytypography")
	public ModelAndView getmytypography(@RequestParam("id") Integer id,ModelAndView mav) {
		mav.addObject("mycommentary", gaca.getmycommentary(id));
		mav.setViewName("back-stagemanagement/mytypography");
		return mav;
	}
	
	
}
