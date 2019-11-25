package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Score;

public interface ScoreService {

	public Score get(int userId,int cookbookId);
	
	public void add(Score score);
	
	public List<Score> getall(int userId, int beginIndex, int offset);
	
	public List<Score> getAllScore();
}
