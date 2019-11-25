package com.example.demo.model;

public class Comment {
    private Integer userId;

    private Integer cookbookId;
    
    private String commentInf;

    public String getCommentInf() {
        return commentInf;
    }

    public void setCommentInf(String commentInf) {
        this.commentInf = commentInf == null ? null : commentInf.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCookbookId() {
        return cookbookId;
    }

    public void setCookbookId(Integer cookbookId) {
        this.cookbookId = cookbookId;
    }
}