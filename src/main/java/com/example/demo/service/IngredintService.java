package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Ingredint;

public interface IngredintService {
	
	public void add(Ingredint ingredint);
	
	public List<Ingredint> get(int cookbookId);
	
	public void delete(int cookbookId);
	
	public List<Integer> getCookbookList(String ingredintName, int beginIndex, int offset);

}
