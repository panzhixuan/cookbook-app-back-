package com.example.demo.model;

public class Step {
    private Integer cookbookId;

    private String stepInf;

    public Integer getCookbookId() {
        return cookbookId;
    }

    public void setCookbookId(Integer cookbookId) {
        this.cookbookId = cookbookId;
    }

    public String getStepInf() {
        return stepInf;
    }

    public void setStepInf(String stepInf) {
        this.stepInf = stepInf == null ? null : stepInf.trim();
    }
}