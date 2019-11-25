package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Comment;

@Mapper
public interface CommentMapper {
	
	public void add(Comment comment);
	
	public List<Comment> get(int cookbookId);
	
	public void delete(int userId,int cookbookId);

}