package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Step;

public interface StepService {
	public void add(Step step);
	
	public List<Step> get(int cookbookId);
	
	public void delete(int cookbookId);
}
