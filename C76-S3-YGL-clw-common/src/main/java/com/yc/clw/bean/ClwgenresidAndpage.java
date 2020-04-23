package com.yc.clw.bean;

import java.io.Serializable;

public class ClwgenresidAndpage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer page;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPage() {
		return page;
	}
	
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
}
