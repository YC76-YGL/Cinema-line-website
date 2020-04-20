package com.yc.clw.bean;

import java.io.Serializable;
import java.util.Date;

public class ClwCommentary implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String commentary;

    private Integer user;

    private Integer movielist;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary == null ? null : commentary.trim();
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getMovielist() {
        return movielist;
    }

    public void setMovielist(Integer movielist) {
        this.movielist = movielist;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}