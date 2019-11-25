package com.example.demo.model;

public class Score {
    private Integer userId;

    private Integer cookbookId;
    
    private Integer score;

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
    
    public Integer getScore() {
    	return score;
    }
    
    public void setScore(Integer score) {
    	this.score = score;
    }
    
    
}