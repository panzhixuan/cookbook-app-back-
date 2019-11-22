package com.example.demo.model;

public class Ingredint {
    private Integer cookbookId;

    private String ingredintName;

    private String ingredintNum;

    public Integer getCookbookId() {
        return cookbookId;
    }

    public void setCookbookId(Integer cookbookId) {
        this.cookbookId = cookbookId;
    }

    public String getIngredintName() {
        return ingredintName;
    }

    public void setIngredintName(String ingredintName) {
        this.ingredintName = ingredintName == null ? null : ingredintName.trim();
    }

    public String getIngredintNum() {
        return ingredintNum;
    }

    public void setIngredintNum(String ingredintNum) {
        this.ingredintNum = ingredintNum == null ? null : ingredintNum.trim();
    }
}