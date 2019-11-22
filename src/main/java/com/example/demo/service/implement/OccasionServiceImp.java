package com.example.demo.service.implement;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.OccasionMapper;
import com.example.demo.service.OccasionService;

@Service
@Transactional
public class OccasionServiceImp implements OccasionService{
	@Resource
    private OccasionMapper occasionMapper;
	
	public String IdfindName(int Id) {
		return occasionMapper.IdfindName(Id);
	}
	
	public int NamefindId(String Name) {
		return occasionMapper.NamefindId(Name);
	}
}
