package com.example.demo.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.StepMapper;
import com.example.demo.model.Step;
import com.example.demo.service.StepService;

@Service
@Transactional
public class StepServiceImp implements StepService{
	@Resource
    private StepMapper stepMapper;
	
	public void add(Step step) {
		stepMapper.add(step);
	}
	
	public List<Step> get(int cookbookId){
		return stepMapper.get(cookbookId);
	}
	
	public void delete(int cookbookId) {
		stepMapper.delete(cookbookId);
	}
}
