package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Cookbook;

@Mapper
public interface CookbookMapper {
	
	public void add(int cookbookLikenum,int cookbookVisitnum,String cookbookTip,String cookbookNutrition,String cookbookPhoto,String cookbookName,int userId,int cookbookTaste,int cookbookCuisine,int cookbookOccasion);

	public Cookbook findbyPhoto(String cookbookPhoto);
	
	public List<Cookbook> findbyuserId(int userId,int beginIndex, int offset);
	
	public void update(int cookbookLikenum,int cookbookVisitnum,String cookbookTip,String cookbookNutrition,String cookbookPhoto,String cookbookName,int userId,int cookbookTaste,int cookbookCuisine,int cookbookOccasion,int cookbookId);

	public void delete(int cookbookId);
	
	public void updatevisit(int cookbookId,int cookbookVisitnum);
	
	public void updatelike(int cookbookId,int cookbookLikenum);
	
	public Cookbook findbycookbookId(int cookbookId);
	
	public List<Cookbook> findbyType(int cookbookTaste,int cookbookCuisine,int cookbookOccasion, int begin, int offset);
	
	public List<Cookbook> findbyCuisine(int cookbookCuisine,int beginIndex, int offset);
	
	public List<Cookbook> findbyName(String cookbookName, int beginIndex, int offset);
	
	public List<Cookbook> getall();
}
