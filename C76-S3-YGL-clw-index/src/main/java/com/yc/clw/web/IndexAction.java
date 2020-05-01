package com.yc.clw.web;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yc.clw.bean.ClwCommentary;
import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwNews;
import com.yc.clw.bean.ClwReplytocomments;
import com.yc.clw.bean.ClwUser;
import com.yc.clw.biz.ActiveAndpageBiz;
import com.yc.clw.biz.BizException;
import com.yc.clw.biz.ClwCount;
import com.yc.clw.biz.ClwCountBiz;
import com.yc.clw.biz.CommentaryBiz;
import com.yc.clw.biz.MergingmethoBiz;
import com.yc.clw.biz.MovielistBiz;
import com.yc.clw.biz.NewsBiz;
import com.yc.clw.biz.ReplytocommentsBiz;
import com.yc.clw.biz.UserBiz;

@RestController
@SessionAttributes({ "loginedUser", "genresid" ,"Modificationtips"})
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

	@Resource
	MovielistBiz mb;
	
	@GetMapping("genres")
	public ModelAndView geners(@RequestParam(defaultValue = "1") Integer page, @RequestParam("id") Integer id,
			ModelAndView mav) {
		mav.addObject("genresid","");
		mmb.common(mav);
		String msg = null;
		double getpage = mb.getgenrespage(id);
		if(page > getpage) {
			page = (int) getpage;
			msg = "已经是这个类型的全部电影了";
		}else if(page <= 0) {
			msg = "这一页已经是首页了";
			page = 1;
		}
		ActiveAndpageBiz cgape = new ActiveAndpageBiz(id,page,msg,(int)getpage);
		mav.addObject("getmovie", gaca.getgenresmovie(page,id));
		mav.addObject("genresid", cgape);
		mav.setViewName("genres");
		return mav;
	}

	@GetMapping("country")
	public ModelAndView country(@RequestParam(defaultValue = "1") Integer page, @RequestParam("id") Integer id,
			ModelAndView mav) {
		mav.addObject("genresid","");
		mmb.common(mav);
		String msg = null;
		double getpage = mb.getgenrespage(id);
		if(page >= getpage) {
			page = (int) getpage;
			msg = "已经是这个类型的全部电影了";
		}else if(page <= 0) {
			msg = "这一页已经是首页了";
			page = 1;
		}
		ActiveAndpageBiz cgape = new ActiveAndpageBiz(id,page,msg,(int)getpage);
		mav.addObject("genresid", cgape);
		mav.addObject("getmovie", gaca.getcountrmovie(page,id));
		mav.setViewName("genres");
		return mav;
	}

	@GetMapping("tologin")
	public ModelAndView tologin(ModelAndView mav) {
		mav.setViewName("Login");
		return mav;
	}
	
	@PostMapping("tologin")
	public ModelAndView tologin(ModelAndView mav,@RequestParam("uri")String uri) {
		mav.addObject("uri", uri);
		mav.setViewName("Login");
		return mav;
	}
	
	@PostMapping("Unlockpassword")
	public ModelAndView Unlockpassword(@RequestParam("pwd")String pwd,ModelAndView mav,HttpSession session) {
		ClwUser user = (ClwUser) session.getAttribute("loginedUser");
		if(user.getPassword().equals(pwd) == false) {
			mav.setViewName("back-stagemanagement/lock-screen");
		}else {
			getadmin(mav,user);
		}
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
	public ModelAndView reg(@SessionAttribute("vcode") String sessionVcode,ModelAndView mav, ClwUser user, String repwd,String yzm) {
		try {
			if(sessionVcode.equals(yzm) == false) {
				mav.setViewName("Reg");
			}else {
				uBiz.reg(user, repwd);
				mav.setViewName("Login");
			}
		} catch (BizException e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.setViewName("Reg");
		}
		return mav;
	}

	@GetMapping("logout")
	public ModelAndView logout(ModelAndView mav) {
		ClwUser user = null;
		mmb.common(mav);
		mav.addObject("loginedUser", user);
		mav.setViewName("index");
		return mav;
	}

	@GetMapping("new")
	public ModelAndView news(ModelAndView mav) {
		mmb.newscommon(mav);
		mav.addObject("getQuerySingular", gaca.getQuerySingular());
		mav.addObject("getQueryEven", gaca.getQueryEven());
		mav.setViewName("news");
		return mav;
	}
	
	@GetMapping("contact")
	public ModelAndView contanct(ModelAndView mav) {
		mmb.common(mav);
		mav.addObject("Modificationtips", "");
		mav.setViewName("contact");
		return mav;
	}
	
	@GetMapping("fql")
	public ModelAndView faq(ModelAndView mav) {
		mmb.common(mav);
		mav.setViewName("faq");
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
		mav.addObject("Modificationtips", "");
			List<ClwMovielist> list = gaca.getidmovie(id);
			if (list != null) {
				mmb.common(mav);
				mav.addObject("getidmovie", list);
				mav.addObject("getClwCommentarylist", gaca.getClwCommentary(id));
				mav.setViewName("single");
		}
		return mav;
	}

	@GetMapping("list")
	public ModelAndView list(ModelAndView mav) {
		mmb.common(mav);
		mav.addObject("gcml", gaca.getClwMovielist());
		mav.setViewName("list");
		return mav;
	}
	
	@Resource
	ClwCountBiz ccbz;
	
	@GetMapping("admin")
	public ModelAndView getadmin(ModelAndView mav,@SessionAttribute("loginedUser") ClwUser user) {
		if(user == null) {
			mav.setViewName("login");
		}else {
			ClwCount cct = new ClwCount();
			cct = ccbz.getcount();
			mav.addObject("cct", cct);
			mav.addObject("getusenumber", gaca.getusenumber(1));
			mav.setViewName("Administrator");
		}
		return mav;
	}

	
	@GetMapping("user_basic")
	public ModelAndView getuser_basic(ModelAndView mav) {
		mav.addObject("Modificationtips", "");
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
		mav.addObject("Modificationtips", "");
		mav.setViewName("back-stagemanagement/ChangePassword");
		return mav;
	}
	
	@PostMapping("search")
	public ModelAndView getsearchmovie(ModelAndView mav,@RequestParam("Search")String Search) {
		mmb.common(mav);
		double getpage = mb.getnamepage(Search);
		ActiveAndpageBiz cgape = new ActiveAndpageBiz(1, (int)getpage, Search);
		mav.addObject("genresid", cgape);
		mav.addObject("getSearch", gaca.getseachmovie(Search));
		mav.setViewName("horror");
		return mav;
	}
	
	@GetMapping("horror")
	public ModelAndView gethorrormovie(ModelAndView mav,@RequestParam(defaultValue = "1") Integer page,@RequestParam("Search")String Search) {
		mmb.common(mav);
		double getpage = mb.getnamepage(Search);
		mav.addObject("getSearch", gaca.getseachmovie(Search));
		ActiveAndpageBiz cgape = new ActiveAndpageBiz(page, (int)getpage, Search);
		mav.addObject("genresid", cgape);
		mav.setViewName("horror");
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
	
	@GetMapping("lock-screen")
	public ModelAndView getlock(ModelAndView mav) {
		mav.setViewName("back-stagemanagement/lock-screen");
		return mav;
	}
	
	@PostMapping("Createnews")
	public ModelAndView getCreatenews(ClwNews news,@RequestParam("file") MultipartFile file,ModelAndView mav) {
		String msg;
		try {
			file.transferTo(new File(myUploadPath + file.getOriginalFilename()));
			// 定义用户头像的图片的 web 路径
			String head = "sjkimage/" + file.getOriginalFilename();
			news.setOther(head);
			news.setCreatetime(new Date());
			msg = nb.create(news);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "服务器出错了";
		}
		mav.addObject("Modificationtips", msg);
		mav.setViewName("back-stagemanagement/Pressrelease");
		return mav;
	}
	@Resource
	CommentaryBiz ctb;
	
	@PostMapping("createreply")
	public ModelAndView getreply(ClwCommentary ccy,ModelAndView mav) {
		String msg = null;
		msg = ctb.crete(ccy);
		List<ClwMovielist> list = gaca.getidmovie(ccy.getMovielist());
			mmb.common(mav);
			mav.addObject("getidmovie", list);
			mav.addObject("getClwCommentarylist", gaca.getClwCommentary(ccy.getMovielist()));
			mav.setViewName("single");
		mav.addObject("Modificationtips", msg);
		return mav;
	}
	
	@Resource
	ReplytocommentsBiz rtb;
	
	@PostMapping("replytocomments")
	public ModelAndView replytocomments(ClwReplytocomments record,ModelAndView mav) {
		String msg = null;
		if(record.getUser() == null) {
			msg = "发送失败!!!请先登录";
		}else {
			msg = rtb.CreateClwReply(record);
		}
		mmb.common(mav);
		mav.addObject("Modificationtips", msg);
		mav.setViewName("contact");
		return mav;
	}
	
	@GetMapping("mytypography")
	public ModelAndView getmytypography(@RequestParam("id") Integer id,ModelAndView mav) {
		mav.addObject("mycommentary", gaca.getmycommentary(id));
		mav.setViewName("back-stagemanagement/mytypography");
		return mav;
	}
	
	@PostMapping("sendVcode")
	@ResponseBody
	public String Sendcode(String email,HttpSession session,ModelAndView mav) {
		String msg;
		System.out.println(email);
		try {
			msg = "发送成功" ;
			String vcode = uBiz.forget(email);
			session.setAttribute("vcode", vcode);
			return msg;
		} catch (BizException e) {
			msg = "发送失败" ;
			e.printStackTrace();
			return msg;
		}
	}
	
	@PostMapping("CPassword")
	public ModelAndView CPassword(ClwUser user,String yzm,String repassword,
			@SessionAttribute("vcode") String sessionVcode,ModelAndView mav) {
		String msg = null;
		if(sessionVcode.equals(yzm) == false) {
			msg = "验证码输入错误";
		}else if(user.getPassword().equals(repassword) == false) {
			msg = "两次密码不一致";
		}else {
			try {
				uBiz.updatepassword(user);
				msg = "修改成功";
			} catch (BizException e) {
				e.printStackTrace();
				msg = "修改失败";
			}
		}
		mav.addObject("Modificationtips", msg);
		mav.setViewName("back-stagemanagement/ChangePassword");
		return mav;		
	}
	
	@Value("${userlookPath}")
	private String userlookPath;
	
	@PostMapping("Modifypersonaldata")
	public ModelAndView Modifypersonaldata(@RequestParam("file") MultipartFile file,ModelAndView mav,ClwUser user) {
		String msg;
		try {
			file.transferTo(new File(userlookPath + file.getOriginalFilename()));
			// 定义用户头像的图片的 web 路径
			String head = "userlook/" + file.getOriginalFilename();
			user.setLook(head);
			msg =  uBiz.updatelookpath(user);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "修改失败" ;
		}
		mav.addObject("Modificationtips", msg);
		mav.setViewName("back-stagemanagement/user_basic");
		return mav;
	}
	
	@GetMapping("comedy")
	public ModelAndView getcomedy(ModelAndView mav) {
		mmb.common(mav);
		return mav;
	}
	
	@GetMapping("Directionalpush")
	public String getpush() {
		return "你好";
	}
	
}
