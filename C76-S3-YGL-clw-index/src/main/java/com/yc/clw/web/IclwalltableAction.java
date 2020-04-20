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
	
	@GetMapping("getnewmovie")
	public List<ClwMovielist> getnewmovie();
	
	@GetMapping("getfindall")
	public List<ClwNews> getfindall();
	
	@GetMapping("latestnew")
	public List<ClwNews> latestnew();
	
	@GetMapping("getclwnews")
	public ClwNews getclwnews(@RequestParam("id")Integer id) ;
	
	@GetMapping("getgenresmovie")
	public List<ClwMovielist> getgenresmovie(@RequestParam("id")Integer id);
	
	@GetMapping("getcountrmovie")
	public List<ClwMovielist> getcountrmovie(@RequestParam("id")Integer id);
	
	@GetMapping("seachmovie")
	public List<ClwMovielist> getseachmovie(@RequestParam("name")String name);
	
	@GetMapping("getidmovie")
	public List<ClwMovielist> getidmovie(@RequestParam("id")Integer id);
	
	@GetMapping("getClwCommentary")
	public List<ClwCommentary> getClwCommentary(@RequestParam("id")Integer id);
	
}
