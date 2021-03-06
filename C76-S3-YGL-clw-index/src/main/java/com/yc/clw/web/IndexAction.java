package com.yc.clw.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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

import com.yc.clw.bean.ClwCollection;
import com.yc.clw.bean.ClwCommentary;
import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwNews;
import com.yc.clw.bean.ClwReplytocomments;
import com.yc.clw.bean.ClwUser;
import com.yc.clw.biz.ActiveAndpageBiz;
import com.yc.clw.biz.BizException;
import com.yc.clw.biz.CommentaryBiz;
import com.yc.clw.biz.MergingmethoBiz;
import com.yc.clw.biz.MovielistBiz;
import com.yc.clw.biz.NewsBiz;
import com.yc.clw.biz.ReplytocommentsBiz;
import com.yc.clw.biz.UserBiz;

@RestController
@SessionAttributes({ "loginedUser", "genresid", "Modificationtips" })
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
		mav.addObject("getMostpopular", gaca.getMostpopular(1));
		mav.setViewName("index");
		return mav;
	}

	@Resource
	MovielistBiz mb;

	@GetMapping("genres")
	public ModelAndView geners(@RequestParam(defaultValue = "1") Integer page, @RequestParam("id") Integer id,
			ModelAndView mav) {
		mav.addObject("genresid", "");
		mmb.common(mav);
		String msg = null;
		double getpage = mb.getgenrespage(id);
		if (page > getpage) {
			page = (int) getpage;
			msg = "已经是这个类型的全部电影了";
		} else if (page <= 0) {
			msg = "这一页已经是首页了";
			page = 1;
		}
		ActiveAndpageBiz cgape = new ActiveAndpageBiz(id, page, msg, (int) getpage);
		mav.addObject("getmovie", gaca.getgenresmovie(page, id));
		mav.addObject("genresid", cgape);
		mav.addObject("getcommentmost", gaca.getcommentmost());
		mav.setViewName("genres");
		return mav;
	}

	@GetMapping("country")
	public ModelAndView country(@RequestParam(defaultValue = "1") Integer page, @RequestParam("id") Integer id,
			ModelAndView mav) {
		mav.addObject("genresid", "");
		mmb.common(mav);
		String msg = null;
		double getpage = mb.getgenrespage(id) + 1;
		if (page >= getpage) {
			page = (int) getpage;
			msg = "已经是这个类型的全部电影了";
		} else if (page <= 0) {
			msg = "这一页已经是首页了";
			page = 1;
		}
		ActiveAndpageBiz cgape = new ActiveAndpageBiz(id, page, msg, (int) getpage);
		mav.addObject("genresid", cgape);
		mav.addObject("getmovie", gaca.getcountrmovie(page, id));
		mav.addObject("getcommentmost", gaca.getcommentmost());
		mav.setViewName("genres");
		return mav;
	}

	@GetMapping("tologin")
	public ModelAndView tologin(ModelAndView mav,@RequestParam(name = "uri", required = false) String uri) {
		mav.addObject("uri", uri);
		mav.setViewName("Login");
		return mav;
	}


	@PostMapping("Unlockpassword")
	public ModelAndView Unlockpassword(@RequestParam("pwd") String pwd, ModelAndView mav, HttpSession session) {
		ClwUser user = (ClwUser) session.getAttribute("loginedUser");
		if (user.getPassword().equals(pwd) == false) {
			mav.setViewName("back-stagemanagement/lock-screen");
		} else {
			getadmin(mav, user);
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
				mav.setViewName("redirect:http://127.0.0.1" + uri);
			} else {
				index(mav);
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
	public ModelAndView reg(@SessionAttribute("vcode") String sessionVcode, ModelAndView mav, ClwUser user,
			String repwd, String yzm) {
		try {
			if (sessionVcode.equals(yzm) == false) {
				mav.setViewName("Reg");
			} else {
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
		mav.clear();
		mmb.common(mav);
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
	public ModelAndView contanct(ModelAndView mav,HttpSession session) {
		mmb.common(mav);
		ClwUser user = (ClwUser) session.getAttribute("loginedUser");
		if(user == null) {
			mav.setViewName("Login");
		}else {
			mav.addObject("Modificationtips", "");
			mav.setViewName("contact");
		}
		
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
			ClwNews news = gaca.getclwnews(id);
			mmb.newscommon(mav);
			mav.addObject("great", gaca.getgareaterratmovie());
			mav.addObject("na", nb.alike(news.getUser(), id));
			mav.addObject("getclwnews", news);
			mav.setViewName("news-single");
		}
		return mav;
	}

	@GetMapping("single")
	public ModelAndView single(@RequestParam("id") Integer id, ModelAndView mav) {
		mav.addObject("Modificationtips", "");
		ClwMovielist list = gaca.getidmovie(id);
		if (list != null) {
			mmb.common(mav);
			mav.addObject("mge", mb.getalikemovie(list.getCountry(), list.getId()));
			mav.addObject("getidmovie", list);
			mav.addObject("gl", gaca.latestnew());
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

	@GetMapping("admin")
	public ModelAndView getadmin(ModelAndView mav, @SessionAttribute("loginedUser") ClwUser user) {
		return mmb.getinformation(mav, user);
	}

	@GetMapping("user_basic")
	public ModelAndView getuser_basic(ModelAndView mav) {
		mav.addObject("Modificationtips", "");
		mav.setViewName("back-stagemanagement/user_basic");
		return mav;
	}

	@GetMapping("typography")
	public ModelAndView gettypography(@RequestParam("id") Integer id, ModelAndView mav) {
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
	public ModelAndView getsearchmovie(ModelAndView mav, @RequestParam("Search") String Search) {
		mmb.common(mav);
		double getpage = mb.getnamepage(Search);
		ActiveAndpageBiz cgape = new ActiveAndpageBiz(1, (int) getpage, Search);
		mav.addObject("genresid", cgape);
		mav.addObject("getcommentmost", gaca.getcommentmost());
		mav.addObject("getSearch", gaca.getseachmovie(Search));
		mav.setViewName("horror");
		return mav;
	}

	@GetMapping("horror")
	public ModelAndView gethorrormovie(ModelAndView mav, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam("Search") String Search) {
		mmb.common(mav);
		double getpage = mb.getnamepage(Search);
		mav.addObject("getSearch", gaca.getseachmovie(Search));
		ActiveAndpageBiz cgape = new ActiveAndpageBiz(page, (int) getpage, Search);
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
	public ModelAndView getCreatenews(ClwNews news, @RequestParam("file") MultipartFile file, ModelAndView mav) {
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
	public ModelAndView getreply(ClwCommentary ccy, ModelAndView mav) {
		String msg = null;
		msg = ctb.crete(ccy);
		ClwMovielist list = gaca.getidmovie(ccy.getMovielist());
		mmb.common(mav);
		mav.addObject("getidmovie", list);
		mav.addObject("getClwCommentarylist", gaca.getClwCommentary(ccy.getMovielist()));
		mav.setViewName("single");
		mav.addObject("Modificationtips", msg);
		return mav;
	}

	@Resource
	ReplytocommentsBiz rtb;
	
	

	@PostMapping("reply")
	@ResponseBody
	public String replytocomments(ClwReplytocomments record,HttpSession session) {
			ClwUser user = (ClwUser) session.getAttribute("loginedUser");
			
			record.setUser(user.getId());
			String msg = rtb.CreateClwReply(record);
			return msg;
	}

	@GetMapping("mytypography")
	public ModelAndView getmytypography(@RequestParam("id") Integer id, ModelAndView mav) {
		mav.addObject("mycommentary", gaca.getmycommentary(id));
		mav.setViewName("back-stagemanagement/mytypography");
		return mav;
	}

	@PostMapping("sendVcode")
	@ResponseBody
	public String Sendcode(String email, HttpSession session, ModelAndView mav) {
		String msg;
		try {
			msg = "发送成功";
			String vcode = uBiz.forget(email);
			session.setAttribute("vcode", vcode);
			return msg;
		} catch (BizException e) {
			msg = "发送失败";
			e.printStackTrace();
			return msg;
		}
	}
	
	@PostMapping("Createreg")
	@ResponseBody
	public String Createreg(String email, HttpSession session) {
		String msg;
		try {
			msg = "发送成功";
			String vcode = uBiz.create(email);
			session.setAttribute("vcode", vcode);
			return msg;
		} catch (BizException e) {
			msg = "发送失败";
			e.printStackTrace();
			return msg;
		}
	}
	
	@PostMapping("sendname")
	@ResponseBody
	public String selectname(String name) {
		return uBiz.selectname(name);
	}

	@PostMapping("CPassword")
	public ModelAndView CPassword(ClwUser user, String yzm, String repassword,
			@SessionAttribute("vcode") String sessionVcode, ModelAndView mav) {
		String msg = null;
		if (sessionVcode.equals(yzm) == false) {
			msg = "验证码输入错误";
		} else if (user.getPassword().equals(repassword) == false) {
			msg = "两次密码不一致";
		} else {
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
	public ModelAndView Modifypersonaldata(@RequestParam("file") MultipartFile file, ModelAndView mav, ClwUser user) {
		String msg;
		try {
			file.transferTo(new File(userlookPath + file.getOriginalFilename()));
			// 定义用户头像的图片的 web 路径
			String head = "userlook/" + file.getOriginalFilename();
			user.setLook(head);
			msg = uBiz.updatelookpath(user);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "修改失败";
		}
		mav.addObject("Modificationtips", msg);
		mav.setViewName("back-stagemanagement/user_basic");
		return mav;
	}

	@GetMapping("comedy")
	public ModelAndView getcomedy(ModelAndView mav) {
		mav.addObject("gae", gaca.getalmovie(1));
		mav.addObject("page", 1);
		mav.setViewName("back-stagemanagement/basic-table");
		return mav;
	}

	@GetMapping("comedy1")
	public ModelAndView getcomedy1(@RequestParam("page") Integer page, ModelAndView mav) {
		page = page - 1;
		if (page < 1) {
			page = 1;
		}
		mav.addObject("gae", gaca.getalmovie(page));
		mav.addObject("page", page);
		mav.setViewName("back-stagemanagement/basic-table");
		return mav;
	}

	@GetMapping("comedy2")
	public ModelAndView getcomedy2(@RequestParam("page") Integer page, ModelAndView mav) {
		page = page + 1;
		if (page > mb.getpage()) {
			page = (int) mb.getpage();
		}
		mav.addObject("gae", gaca.getalmovie(page));
		mav.addObject("page", page);
		mav.setViewName("back-stagemanagement/basic-table");
		return mav;
	}

	@GetMapping("msg")
	public ModelAndView getpush(ModelAndView mav) {
		mav.setViewName("msg");
		return mav;
	}

	@GetMapping("usercomment")
	public ModelAndView usercomment(@RequestParam("id") Integer id, ModelAndView mav) {
		mav.addObject("gmi", gaca.getidmovie(id));
		mav.setViewName("back-stagemanagement/Usercomments");
		return mav;
	}

	@PostMapping("send")
	@ResponseBody
	public String msend(ClwCommentary ccy) {
		String msg = "";
		if (ccy.getCommentary() == null) {
			msg = "请填写内容";
		} else {
			msg = ctb.crete(ccy);
		}
		return msg;
	}

	@GetMapping("series")
	public ModelAndView getseries(ModelAndView mav,@SessionAttribute("loginedUser") ClwUser user) {
		int page = 1;
		return mmb.getserise(mav, page,user.getId());

	}

	@GetMapping("series1")
	public ModelAndView getseries1(@RequestParam("page") Integer page, ModelAndView mav,@SessionAttribute("loginedUser") ClwUser user) {
		if (page < 1) {
			page = 1;
		}
		return mmb.getserise(mav, page,user.getId());
	}

	@GetMapping("series2")
	public ModelAndView getseries2(@RequestParam("page") Integer page, ModelAndView mav,@SessionAttribute("loginedUser") ClwUser user) {
		if (page > 2) {
			page = 2;
		}
		return mmb.getserise(mav, page,user.getId());
	}
	
	@GetMapping("Filmmanagement")
	public ModelAndView getFilmmanagement(@RequestParam(defaultValue = "1")Integer page,ModelAndView mav,@SessionAttribute("loginedUser") ClwUser user) {
		if(user.getType().equals("1") ) {
			mav.addObject("getalmovie", gaca.getalmovie(page));
			mav.addObject("page", page);
			mav.setViewName("back-stagemanagement/Filmmanagement");
		}else {
			index(mav);
		}
		return mav;
	}
	
	@GetMapping("delete")
	public ModelAndView delete(@RequestParam("id") Integer id,ModelAndView mav,@SessionAttribute("loginedUser") ClwUser user) {
		String msg = gaca.deletemovie(id);
		mav.addObject("msg", msg);
		return getFilmmanagement(1,mav,user);
	}
	
	@GetMapping("update")
	public ModelAndView update(@RequestParam("id") Integer id,ModelAndView mav) {
		mav.addObject("getnamemovie", gaca.getnamemovie(id));
		mav.addObject("getcountary", gaca.getcountary());
		mav.addObject("getgenres", gaca.getgenres());
		mav.setViewName("back-stagemanagement/update");
		return mav;
	}
	
	
	
	@PostMapping("updatemovie")
	@ResponseBody
	public String updatemovie(ClwMovielist list) {
		String msg ;
		msg = mb.update(list);
		return msg;
	}
	
	@GetMapping("add")
	public ModelAndView add(ModelAndView mav) {
		mav.addObject("getcountary", gaca.getcountary());
		mav.addObject("getgenres", gaca.getgenres());
		mav.setViewName("back-stagemanagement/Add");
		return mav;
	}
	
	@Value("${moviePath}")
	private String moviePath;
	
	@PostMapping("sumbitmovie")
	@ResponseBody
	public String sumbitmovie(ClwMovielist list,@RequestParam("file") MultipartFile file) {
		String msg ;
		try {
			file.transferTo(new File(userlookPath + file.getOriginalFilename()));
			// 定义用户头像的图片的 web 路径
			String head = "userlook/" + file.getOriginalFilename();
			list.setImage(head);
			msg = mb.add(list);
		} catch (IllegalStateException e) {
			msg = "失败";
			e.printStackTrace();
		} catch (IOException e) {
			msg = "失败";
			e.printStackTrace();
		}
		return msg;
	}
	
	@GetMapping("collection")
	public ModelAndView collection(@RequestParam("id")Integer id,HttpSession session,ModelAndView mav) {
		ClwUser user = (ClwUser)session.getAttribute("loginedUser") ;
		ClwCollection collection = new ClwCollection(null,id,user.getId(),new Date());
		System.out.println(collection);
		mmb.addcollection(collection,mav);
		return mav;
	}

}
