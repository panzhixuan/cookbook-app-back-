package com.example.demo.model;

public class Taste {
    private Integer tasteId;

    private String tasteName;

    public Integer getTasteId() {
        return tasteId;
    }

    public void setTasteId(Integer tasteId) {
        this.tasteId = tasteId;
    }

    public String getTasteName() {
        return tasteName;
    }

    public void setTasteName(String tasteName) {
        this.tasteName = tasteName == null ? null : tasteName.trim();
    }
}