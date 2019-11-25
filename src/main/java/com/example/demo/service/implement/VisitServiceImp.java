package com.example.demo.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.VisitMapper;
import com.example.demo.model.Visit;
import com.example.demo.service.VisitService;

@Service
@Transactional
public class VisitServiceImp implements VisitService{
	@Resource
    private VisitMapper visitMapper;
	
	public Visit get(int userId,int cookbookId) {
		return visitMapper.get(userId,cookbookId);
	}
	
	public void add(Visit visit) {
		visitMapper.add(visit);
	}
	
	public List<Visit> getall(int userId, int beginIndex, int offset){
		return visitMapper.getall(userId, beginIndex, offset);
	}
}
