package com.yc.clw.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.clw.bean.ClwCommentary;
import com.yc.clw.bean.ClwCountry;
import com.yc.clw.bean.ClwGeners;
import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwNews;
import com.yc.clw.bean.ClwUser;

@FeignClient(name = "clw-back",fallback = GenersAndCountryAction.class)
public interface IclwalltableAction {

	@GetMapping("lessthangetGeners")
	public List<ClwGeners> lessthangetGeners();
	
	@GetMapping("betweengetGeners")
	public List<ClwGeners> betweengetGeners();
	
	@GetMapping("greatthangetGeners")
	public List<ClwGeners> greatthangetGeners();
	
	@GetMapping("greaterthangetcountry")
	public List<ClwCountry> greaterthangetcountry();
	
	@GetMapping("lessthangetcounttry")
	public List<ClwCountry> lessthangetcounttry();
	
	@GetMapping("betweengetcounttry")
	public List<ClwCountry> betweengetcounttry();
	
	@GetMapping("getClwMovielist")
	public List<ClwMovielist> getClwMovielist();
	
	//查询最新电影
	@GetMapping("getnewmovie")
	public List<ClwMovielist> getnewmovie();
	
	//精选电影
	@GetMapping("getSelectedfilms")
	public List<ClwMovielist> getSelectedfilms();
	
	/**
	 * 查询id是单数的
	 * @return
	 */
	@GetMapping("QuerySingular")
	public List<ClwNews> getQuerySingular();
	
	/**
	 * 查询id是双数的
	 * @return
	 */
	@GetMapping("QueryEven")
	public List<ClwNews> getQueryEven();
	
	@GetMapping("latestnew")
	public List<ClwNews> latestnew();
	
	//查询评分高的电影
	@GetMapping("getgareaterratmovie")
	public List<ClwMovielist> getgareaterratmovie();
	
	@GetMapping("getclwnews")
	public ClwNews getclwnews(@RequestParam("id")Integer id) ;
	
	@GetMapping("getgenresmovie")
	public List<ClwMovielist> getgenresmovie(@RequestParam(defaultValue = "1")Integer page,@RequestParam("id")Integer id);
	
	@GetMapping("getcountrmovie")
	public List<ClwMovielist> getcountrmovie(@RequestParam(defaultValue = "1")Integer page,@RequestParam("id")Integer id);
	
	
	@GetMapping("seach")
	public List<ClwMovielist> getseach(@RequestParam(defaultValue = "1")Integer page,String name);
	
	
	@GetMapping("seachmovie")
	public List<ClwMovielist> getseachmovie(@RequestParam("Search")String name);
	
	@GetMapping("getidmovie")
	public List<ClwMovielist> getidmovie(@RequestParam("id")Integer id);
	
	@GetMapping("getClwCommentary")
	public List<ClwCommentary> getClwCommentary(@RequestParam("id")Integer id);
	
	/**
	 * 查询最受欢迎的三部电影
	 * @return
	 */
	@GetMapping("getMostpopular")
	public List<ClwMovielist> getMostpopular();
	
	/**
	 * 查询头条新闻
	 * @return
	 */
	@GetMapping("getHeadlines")
	public List<ClwNews> getHeadlines();
	
	/**
	 * 查询所有电影网页
	 * @param id
	 * @return
	 */
	@GetMapping("getallgenresmovie")
	public List<ClwMovielist> getallgenresmovie(@RequestParam(defaultValue = "1")Integer page);
	
	@GetMapping("getbyidQuerySingular")
	public List<ClwNews> getbyidQuerySingular(@RequestParam("id") Integer id);
	
	@GetMapping("Pressrelease")
	public int CreatePressrelease(ClwNews news);
	
	@GetMapping("mycommentary")
	public List<ClwCommentary> getmycommentary(@RequestParam("id")Integer id);
	
	@GetMapping("getusernumber")
	public List<ClwUser> getusenumber();
}
