package com.yc.clw.biz;

import java.io.Serializable;

public class GraphtabledataBiz implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer thismouthnews;
	
	private Integer lastmouthnews;
	
	private Integer fristmouthnews;
	
	private Integer thismouthcommentry;
	
	private Integer lastmouthcommentry;
	
	private Integer fristmouthcommentry;
	
	private Integer thismouthcollection;
	
	private Integer lastmouthcollection;
	
	private Integer fristmouthollection;

	public Integer getThismouthnews() {
		return thismouthnews;
	}

	public void setThismouthnews(Integer thismouthnews) {
		this.thismouthnews = thismouthnews;
	}

	public Integer getLastmouthnews() {
		return lastmouthnews;
	}

	public void setLastmouthnews(Integer lastmouthnews) {
		this.lastmouthnews = lastmouthnews;
	}

	public Integer getFristmouthnews() {
		return fristmouthnews;
	}

	public void setFristmouthnews(Integer fristmouthnews) {
		this.fristmouthnews = fristmouthnews;
	}

	public Integer getThismouthcommentry() {
		return thismouthcommentry;
	}

	public void setThismouthcommentry(Integer thismouthcommentry) {
		this.thismouthcommentry = thismouthcommentry;
	}

	public Integer getLastmouthcommentry() {
		return lastmouthcommentry;
	}

	public void setLastmouthcommentry(Integer lastmouthcommentry) {
		this.lastmouthcommentry = lastmouthcommentry;
	}

	public Integer getFristmouthcommentry() {
		return fristmouthcommentry;
	}

	public void setFristmouthcommentry(Integer fristmouthcommentry) {
		this.fristmouthcommentry = fristmouthcommentry;
	}

	public Integer getThismouthcollection() {
		return thismouthcollection;
	}

	public void setThismouthcollection(Integer thismouthcollection) {
		this.thismouthcollection = thismouthcollection;
	}

	public Integer getLastmouthcollection() {
		return lastmouthcollection;
	}

	public void setLastmouthcollection(Integer lastmouthcollection) {
		this.lastmouthcollection = lastmouthcollection;
	}

	public Integer getFristmouthollection() {
		return fristmouthollection;
	}

	public void setFristmouthollection(Integer fristmouthollection) {
		this.fristmouthollection = fristmouthollection;
	}

	public GraphtabledataBiz(Integer thismouthnews, Integer lastmouthnews, Integer fristmouthnews,
			Integer thismouthcommentry, Integer lastmouthcommentry, Integer fristmouthcommentry,
			Integer thismouthcollection, Integer lastmouthcollection, Integer fristmouthollection) {
		super();
		this.thismouthnews = thismouthnews;
		this.lastmouthnews = lastmouthnews;
		this.fristmouthnews = fristmouthnews;
		this.thismouthcommentry = thismouthcommentry;
		this.lastmouthcommentry = lastmouthcommentry;
		this.fristmouthcommentry = fristmouthcommentry;
		this.thismouthcollection = thismouthcollection;
		this.lastmouthcollection = lastmouthcollection;
		this.fristmouthollection = fristmouthollection;
	}

	public GraphtabledataBiz() {
		super();
	}

	@Override
	public String toString() {
		return "GraphtabledataBiz [thismouthnews=" + thismouthnews + ", lastmouthnews=" + lastmouthnews
				+ ", fristmouthnews=" + fristmouthnews + ", thismouthcommentry=" + thismouthcommentry
				+ ", lastmouthcommentry=" + lastmouthcommentry + ", fristmouthcommentry=" + fristmouthcommentry
				+ ", thismouthcollection=" + thismouthcollection + ", lastmouthcollection=" + lastmouthcollection
				+ ", fristmouthollection=" + fristmouthollection + "]";
	}
	
	
	
}
