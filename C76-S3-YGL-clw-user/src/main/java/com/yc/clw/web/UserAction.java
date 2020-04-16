package com.yc.clw.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAction {

	@GetMapping("test")
	public String tse() {
		return "user test";
	}
}
