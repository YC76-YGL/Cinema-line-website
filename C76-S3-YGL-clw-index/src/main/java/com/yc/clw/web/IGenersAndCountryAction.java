package com.yc.clw.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.clw.bean.ClwCountry;
import com.yc.clw.bean.ClwGeners;
import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwNews;

@FeignClient(name = "clw-back",fallback = GenersAndCountryAction.class)
public interface IGenersAndCountryAction {

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
	
	@GetMapping("clwnews")
	public ClwNews clwnews(@RequestParam("id")int id);
	
}
