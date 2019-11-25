package com.example.demo.model;

public class Cuisine {
    private Integer cuisineId;

    private String cuisineName;

    public Integer getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName == null ? null : cuisineName.trim();
    }
}