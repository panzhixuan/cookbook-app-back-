package com.example.demo.model;

public class CookBookRecommandResult {
	private int cookbookId;
	private double recommandScore;
	
	public int getCookBookId() {
		return this.cookbookId;
	}
	
	public void setCookBookId(int cookBookId) {
		this.cookbookId = cookBookId;
	}
	
	public double getRecommandScore() {
		return this.recommandScore;
	}
	
	public void setRecommandScore(double recommandScore) {
		this.recommandScore = recommandScore;
	}

}
