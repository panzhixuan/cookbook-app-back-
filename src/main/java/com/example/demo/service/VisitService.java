package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Visit;

public interface VisitService {

	public Visit get(int userId,int cookbookId);
	
	public void add(Visit visit);
	
	public List<Visit> getall(int userId, int beginIndex, int offset);
}
