package com.example.demo.model;

public class Occasion {
    private Integer occasionId;

    private String occasionName;

    public Integer getOccasionId() {
        return occasionId;
    }

    public void setOccasionId(Integer occasionId) {
        this.occasionId = occasionId;
    }

    public String getOccasionName() {
        return occasionName;
    }

    public void setOccasionName(String occasionName) {
        this.occasionName = occasionName == null ? null : occasionName.trim();
    }
}