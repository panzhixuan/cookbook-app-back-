package com.example.demo.model;

public class Cookbook {
    private Integer cookbookId;

    private Integer cookbookLikenum;

    private Integer cookbookVisitnum;

    private String cookbookTip;

    private String cookbookNutrition;

    private String cookbookPhoto;

    private String cookbookName;

    private Integer userId;

    private Integer cookbookTaste;

    private Integer cookbookCuisine;

    private Integer cookbookOccasion;

    public Integer getCookbookId() {
        return cookbookId;
    }

    public void setCookbookId(Integer cookbookId) {
        this.cookbookId = cookbookId;
    }

    public Integer getCookbookLikenum() {
        return cookbookLikenum;
    }

    public void setCookbookLikenum(Integer cookbookLikenum) {
        this.cookbookLikenum = cookbookLikenum;
    }

    public Integer getCookbookVisitnum() {
        return cookbookVisitnum;
    }

    public void setCookbookVisitnum(Integer cookbookVisitnum) {
        this.cookbookVisitnum = cookbookVisitnum;
    }

    public String getCookbookTip() {
        return cookbookTip;
    }

    public void setCookbookTip(String cookbookTip) {
        this.cookbookTip = cookbookTip == null ? null : cookbookTip.trim();
    }

    public String getCookbookNutrition() {
        return cookbookNutrition;
    }

    public void setCookbookNutrition(String cookbookNutrition) {
        this.cookbookNutrition = cookbookNutrition == null ? null : cookbookNutrition.trim();
    }

    public String getCookbookPhoto() {
        return cookbookPhoto;
    }

    public void setCookbookPhoto(String cookbookPhoto) {
        this.cookbookPhoto = cookbookPhoto == null ? null : cookbookPhoto.trim();
    }

    public String getCookbookName() {
        return cookbookName;
    }

    public void setCookbookName(String cookbookName) {
        this.cookbookName = cookbookName == null ? null : cookbookName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCookbookTaste() {
        return cookbookTaste;
    }

    public void setCookbookTaste(Integer cookbookTaste) {
        this.cookbookTaste = cookbookTaste;
    }

    public Integer getCookbookCuisine() {
        return cookbookCuisine;
    }

    public void setCookbookCuisine(Integer cookbookCuisine) {
        this.cookbookCuisine = cookbookCuisine;
    }

    public Integer getCookbookOccasion() {
        return cookbookOccasion;
    }

    public void setCookbookOccasion(Integer cookbookOccasion) {
        this.cookbookOccasion = cookbookOccasion;
    }
}