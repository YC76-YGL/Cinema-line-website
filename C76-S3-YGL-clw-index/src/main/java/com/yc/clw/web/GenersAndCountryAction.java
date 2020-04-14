package com.yc.clw.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yc.clw.bean.ClwCountry;
import com.yc.clw.bean.ClwGeners;

@Component
public class GenersAndCountryAction implements IGenersAndCountryAction {

	@Override
	public List<ClwGeners> lessthangetGeners() {
		List<ClwGeners> list =new ArrayList<ClwGeners>();
		list.add(new ClwGeners(1, "动作"));
		return list;
	}

	@Override
	public List<ClwGeners> betweengetGeners() {
		List<ClwGeners> list =new ArrayList<ClwGeners>();
		list.add(new ClwGeners(1, "喜剧"));
		return list;
	}

	@Override
	public List<ClwGeners> greatthangetGeners() {
		List<ClwGeners> list =new ArrayList<ClwGeners>();
		list.add(new ClwGeners(1, "战争"));
		return list;
	}

	@Override
	public List<ClwCountry> greaterthangetcountry() {
		List<ClwCountry> list =new ArrayList<>();
		list.add(new ClwCountry(1,"中国"));
		return list;
	}

	@Override
	public List<ClwCountry> lessthangetcounttry() {
		List<ClwCountry> list =new ArrayList<>();
		list.add(new ClwCountry(1,"印度"));
		return list;
	}

	@Override
	public List<ClwCountry> betweengetcounttry() {
		List<ClwCountry> list =new ArrayList<>();
		list.add(new ClwCountry(1,"美国"));
		return list;
	}

}
