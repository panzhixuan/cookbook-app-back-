package com.example.demo.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

@Service
@Transactional
public class CommentServiceImp implements CommentService{
	@Resource
    private CommentMapper commentMapper;
	
	public void add(Comment comment) {
		commentMapper.add(comment);
	}
	
	public List<Comment> get(int cookbookId){
		return commentMapper.get(cookbookId);
	}
	
	public void delete(int userId,int cookbookId) {
		commentMapper.delete(userId,cookbookId);
	}
}
