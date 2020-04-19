package com.yc.clw.bean;

import java.util.Date;
import java.util.List;

public class ClwMovielist implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String description;

    private Date createtime;

    private String isHot;

    private Integer geners;

    private Integer actor;

    private Integer actor1;

    private String director;

    private Integer country;

    private Integer score;

    private Integer geners1;

    private String image;

    private String other;
    
    private List<ClwMovielist> children;

    public List<ClwMovielist> getChildren() {
		return children;
	}


	public void setChildren(List<ClwMovielist> children) {
		this.children = children;
	}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot == null ? null : isHot.trim();
    }

    public Integer getGeners() {
        return geners;
    }

    public void setGeners(Integer geners) {
        this.geners = geners;
    }

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public Integer getActor1() {
        return actor1;
    }

    public void setActor1(Integer actor1) {
        this.actor1 = actor1;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGeners1() {
        return geners1;
    }

    public void setGeners1(Integer geners1) {
        this.geners1 = geners1;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }


	@Override
	public String toString() {
		return "ClwMovielist [id=" + id + ", name=" + name + ", description=" + description + ", createtime="
				+ createtime + ", isHot=" + isHot + ", geners=" + geners + ", actor=" + actor + ", actor1=" + actor1
				+ ", director=" + director + ", country=" + country + ", score=" + score + ", geners1=" + geners1
				+ ", image=" + image + ", other=" + other + "]";
	}


	
	
    
}