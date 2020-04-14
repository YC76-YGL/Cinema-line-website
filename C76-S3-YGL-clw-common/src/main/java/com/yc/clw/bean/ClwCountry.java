package com.yc.clw.bean;

public class ClwCountry {
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

	public ClwCountry(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ClwCountry() {
		super();
	}
    
    
}