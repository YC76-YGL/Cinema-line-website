package com.yc.clw.biz;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class ActiveAndpageBiz implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer page;

	private String msg;

	private Integer last;
	
	private String search;

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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}

	public ActiveAndpageBiz(Integer id, Integer page, String msg, Integer last) {
			super();
			this.id = id;
			this.page = page;
			this.msg = msg;
			this.last = last;
		}

	public ActiveAndpageBiz() {
			super();
		}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public ActiveAndpageBiz(Integer page, String msg, Integer last, String search) {
		super();
		this.page = page;
		this.msg = msg;
		this.last = last;
		this.search = search;
	}

	public ActiveAndpageBiz(Integer page, Integer last, String search) {
		super();
		this.page = page;
		this.last = last;
		this.search = search;
	}
	

}
