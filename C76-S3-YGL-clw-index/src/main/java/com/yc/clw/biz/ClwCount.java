package com.yc.clw.biz;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class ClwCount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer user;
	
	private Integer movie;
	
	private Integer news;
	
	private Integer genres;

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getMovie() {
		return movie;
	}

	public void setMovie(Integer movie) {
		this.movie = movie;
	}

	public Integer getNews() {
		return news;
	}

	public void setNews(Integer news) {
		this.news = news;
	}

	public Integer getGenres() {
		return genres;
	}

	public void setGenres(Integer genres) {
		this.genres = genres;
	}

	
}
