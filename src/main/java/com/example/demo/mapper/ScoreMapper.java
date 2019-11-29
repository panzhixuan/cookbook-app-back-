package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Score;

@Mapper
public interface ScoreMapper {

	public Score get(int userId,int cookbookId);
	
	public void add(Score score);
	
	public List<Score> getall(int userId, int begionIndex, int offset);
	
	public List<Score> getAllScore();
	
	public void deleteByUserIdAndCookBookId(int userId, int cookBookId);


}