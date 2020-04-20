package com.yc.clw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 返回Ture则允许访问目标资源
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		HttpSession hs =request.getSession();
		
		if(hs.getAttribute("loginedUser") == null) {
			//报存当前用户访问的地址和参数
			String uri = request.getRequestURI();
			hs.setAttribute("uri", uri);
			response.sendRedirect("http://127.0.0.1/tologin");
			return false;
		}
		return true;
	}

	
}
