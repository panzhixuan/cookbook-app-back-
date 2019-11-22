package com.example.demo.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.IngredintMapper;
import com.example.demo.model.Ingredint;
import com.example.demo.service.IngredintService;

@Service
@Transactional
public class IngredintServiceImp implements IngredintService{
	@Resource
    private IngredintMapper ingredintMapper;
	
	public void add(Ingredint ingredint) {
		ingredintMapper.add(ingredint);
	}
	
	public List<Ingredint> get(int cookbookId){
		return ingredintMapper.get(cookbookId);
	}
	
	public void delete(int cookbookId) {
		ingredintMapper.delete(cookbookId);
	}
	
	public List<Integer> getCookbookList(String ingredintName, int beginIndex, int offset){
		return ingredintMapper.getCookbookList(ingredintName, beginIndex, offset);
	}
}
