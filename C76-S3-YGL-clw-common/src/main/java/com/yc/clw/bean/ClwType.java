package com.yc.clw.bean;

public class ClwType {
    private Integer id;

    private Integer country;

    private Integer isHot;

    private Integer geners;

    private String director;

    private Integer actor;

    private Integer geners1;

    private Integer geners2;

    private Integer geners3;

    private Integer actor2;

    private Integer actor3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getGeners() {
        return geners;
    }

    public void setGeners(Integer geners) {
        this.geners = geners;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public Integer getGeners1() {
        return geners1;
    }

    public void setGeners1(Integer geners1) {
        this.geners1 = geners1;
    }

    public Integer getGeners2() {
        return geners2;
    }

    public void setGeners2(Integer geners2) {
        this.geners2 = geners2;
    }

    public Integer getGeners3() {
        return geners3;
    }

    public void setGeners3(Integer geners3) {
        this.geners3 = geners3;
    }

    public Integer getActor2() {
        return actor2;
    }

    public void setActor2(Integer actor2) {
        this.actor2 = actor2;
    }

    public Integer getActor3() {
        return actor3;
    }

    public void setActor3(Integer actor3) {
        this.actor3 = actor3;
    }
}