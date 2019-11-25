package com.example.demo.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.LikesMapper;
import com.example.demo.model.Likes;
import com.example.demo.service.LikesService;

@Service
@Transactional
public class LikesServiceImp implements LikesService{
	@Resource
    private LikesMapper likesMapper;
	
	public Likes get(int userId,int cookbookId) {
		return likesMapper.get(userId,cookbookId);
	}
	
	public void add(Likes likes) {
		likesMapper.add(likes);
	}
	
	public void delete(int userId,int cookbookId) {
		likesMapper.delete(userId,cookbookId);
	}
	
	public List<Likes> getall(int userId, int beginIndex, int offset){
		return likesMapper.getall(userId, beginIndex, offset);
	}
}
