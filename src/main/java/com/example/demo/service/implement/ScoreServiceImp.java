package com.example.demo.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.ScoreMapper;
import com.example.demo.model.Score;
import com.example.demo.service.ScoreService;

@Service
@Transactional
public class ScoreServiceImp implements ScoreService{
	@Resource
    private ScoreMapper scoreMapper;
	
	public Score get(int userId,int cookbookId) {
		return scoreMapper.get(userId,cookbookId);
	}
	
	public void add(Score score) {
		scoreMapper.add(score);
	}
	
	public List<Score> getall(int userId, int beginIndex, int offset){
		return scoreMapper.getall(userId, beginIndex, offset);
	}
	
	public List<Score> getAllScore() {
		return scoreMapper.getAllScore();
	}

}
