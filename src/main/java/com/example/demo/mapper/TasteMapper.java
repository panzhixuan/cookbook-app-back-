package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Taste;

@Mapper
public interface TasteMapper {
	public String IdfindName(int Id);
	
	public int NamefindId(String Name);
}