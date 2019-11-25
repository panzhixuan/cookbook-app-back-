package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Occasion;

@Mapper
public interface OccasionMapper {
	public String IdfindName(int Id);
	
	public int NamefindId(String Name);
}