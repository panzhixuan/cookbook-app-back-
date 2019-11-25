package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Step;

@Mapper
public interface StepMapper {

	public void add(Step step);
	
	public List<Step> get(int cookbookId);
	
	public void delete(int cookbookId);
}