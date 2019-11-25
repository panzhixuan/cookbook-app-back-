package com.example.demo.service.implement;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.CuisineMapper;
import com.example.demo.service.CuisineService;

@Service
@Transactional
public class CuisineServiceImp implements CuisineService{
	@Resource
    private CuisineMapper cuisineMapper;
	
	public String IdfindName(int Id) {
		return cuisineMapper.IdfindName(Id);
	}
	
	public int NamefindId(String Name) {
		return cuisineMapper.NamefindId(Name);
	}
}
