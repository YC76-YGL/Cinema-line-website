package com.yc.clw.bean;

import java.io.Serializable;

public class ClwGeners implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public ClwGeners(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ClwGeners() {
		super();
	}
    
    
}