package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Comment;

public interface CommentService {
	
	public void add(Comment comment);
	
	public List<Comment> get(int cookbookId);
	
	public void delete(int userId,int cookbookId);
}
