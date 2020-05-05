package com.yc.clw.bean;

import java.io.Serializable;
import java.util.Date;

public class ClwReplytocomments implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String type;

    private String describe;

    private Integer user;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
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

	public ClwReplytocomments(Integer id, String type, String describe, Integer user, Date createtime) {
		super();
		this.id = id;
		this.type = type;
		this.describe = describe;
		this.user = user;
		this.createtime = createtime;
	}

	public ClwReplytocomments() {
		super();
	}
    
    
}