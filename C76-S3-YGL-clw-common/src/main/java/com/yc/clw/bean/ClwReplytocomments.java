package com.yc.clw.bean;

public class ClwReplytocomments {
    private Integer id;

    private String replytocomments;

    private Integer commentary;

    private Integer user;

    private Integer byreply;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplytocomments() {
        return replytocomments;
    }

    public void setReplytocomments(String replytocomments) {
        this.replytocomments = replytocomments == null ? null : replytocomments.trim();
    }

    public Integer getCommentary() {
        return commentary;
    }

    public void setCommentary(Integer commentary) {
        this.commentary = commentary;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getByreply() {
        return byreply;
    }

    public void setByreply(Integer byreply) {
        this.byreply = byreply;
    }
}