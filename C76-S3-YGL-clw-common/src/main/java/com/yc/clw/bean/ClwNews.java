package com.yc.clw.bean;

import java.util.Date;

public class ClwNews implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String title;

	private String content;

	private Date releasetime;

	private String watch;

	private String other;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Date getreleasetime() {
		return releasetime;
	}

	public void setreleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

	public String getWatch() {
		return watch;
	}

	public void setWatch(String watch) {
		this.watch = watch == null ? null : watch.trim();
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other == null ? null : other.trim();
	}

	public ClwNews(Integer id, String title, String content, Date releasetime, String watch, String other) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.releasetime = releasetime;
		this.watch = watch;
		this.other = other;
	}

	public ClwNews(Integer id, String title, String content, String watch) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.watch = watch;
	}
	
	
	
}