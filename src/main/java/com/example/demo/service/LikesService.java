package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Likes;
import com.example.demo.model.Visit;

public interface LikesService {

	public Likes get(int userId,int cookbookId);
	
	public void add(Likes likes);
	
	public void delete(int userId,int cookbookId);
	
	public List<Likes> getall(int userId, int beginIndex, int offset);
}
