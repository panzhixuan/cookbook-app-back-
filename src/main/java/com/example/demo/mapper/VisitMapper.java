package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Visit;

@Mapper
public interface VisitMapper {

	public Visit get(int userId,int cookbookId);
	
	public void add(Visit visit);
	
	public List<Visit> getall(int userId, int begionIndex, int offset);
}