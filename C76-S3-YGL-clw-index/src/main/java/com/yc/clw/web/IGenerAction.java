package com.yc.clw.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.clw.bean.ClwGeners;

@FeignClient("clw-back")
public interface IGenerAction {

	/**
	 * http://clw-back/getGeners
	 * @return
	 */
	@GetMapping("getGeners")
	public List<ClwGeners> getGeners();
}
