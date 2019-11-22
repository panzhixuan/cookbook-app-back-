package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Likes;

@Mapper
public interface LikesMapper {

	public Likes get(int userId,int cookbookId);
	
	public void add(Likes likes);
	
	public void delete(int userId,int cookbookId);
	
	public List<Likes> getall(int userId, int beginIndex, int offset);
}