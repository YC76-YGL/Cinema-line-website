package com.yc.clw.bean;

import java.io.Serializable;

public class ClwUser implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String username;

    private String password;

    private Integer sex;

    private String email;

    private String mobile;

    private String type;

    private String look;
    
    private ClwCount newsnumber;
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look == null ? null : look.trim();
    }
    

	public ClwUser(Integer id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public ClwUser(String username) {
		super();
		this.username = username;
	}

	public ClwUser() {
		super();
	}

	public ClwCount getNewsnumber() {
		return newsnumber;
	}

	public void setNewsnumber(ClwCount newsnumber) {
		this.newsnumber = newsnumber;
	}

	
	
    
}