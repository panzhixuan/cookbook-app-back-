package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CuisineMapper {
	public String IdfindName(int Id);
	
	public int NamefindId(String Name);
}