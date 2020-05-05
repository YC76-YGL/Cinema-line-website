package com.yc.clw.bean;

import java.io.Serializable;
import java.util.Date;

public class ClwCollection implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer movie;

    private Integer user;

    private Date createtime;
    
    private ClwMovielist cml;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovie() {
        return movie;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public ClwMovielist getCml() {
		return cml;
	}

	public void setCml(ClwMovielist cml) {
		this.cml = cml;
	}


	public ClwCollection(Integer id, Integer movie, Integer user, Date createtime) {
		super();
		this.id = id;
		this.movie = movie;
		this.user = user;
		this.createtime = createtime;
	}

	public ClwCollection() {
		super();
	}
    
    
}