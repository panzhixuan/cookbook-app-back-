package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Ingredint;

@Mapper
public interface IngredintMapper {
	
	public void add(Ingredint ingredint);
	
	public List<Ingredint> get(int cookbookId);
	
	public void delete(int cookbookId);
	
	public List<Integer> getCookbookList(String ingredintName, int beginIndex, int offset);
}