package com.example.demo.service.implement;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.TasteMapper;
import com.example.demo.service.TasteService;

@Service
@Transactional
public class TasteServiceImp implements TasteService{
	@Resource
    private TasteMapper tasteMapper;
	
	public String IdfindName(int Id) {
		return tasteMapper.IdfindName(Id);
	}
	
	public int NamefindId(String Name) {
		return tasteMapper.NamefindId(Name);
	}
}
