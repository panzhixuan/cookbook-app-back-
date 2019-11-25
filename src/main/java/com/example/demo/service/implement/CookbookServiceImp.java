package com.example.demo.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.CookbookMapper;
import com.example.demo.model.Cookbook;
import com.example.demo.service.CookbookService;

@Service
@Transactional
public class CookbookServiceImp implements CookbookService{
	@Resource
    private CookbookMapper cookbookMapper;
	
	public void add(int cookbookLikenum,int cookbookVisitnum,String cookbookTip,String cookbookNutrition,String cookbookPhoto,String cookbookName,int userId,int cookbookTaste,int cookbookCuisine,int cookbookOccasion) {
		cookbookMapper.add(cookbookLikenum,cookbookVisitnum,cookbookTip,cookbookNutrition,cookbookPhoto,cookbookName,userId,cookbookTaste,cookbookCuisine,cookbookOccasion);
	}
	
	public Cookbook findbyPhoto(String cookbookPhoto) {
		return cookbookMapper.findbyPhoto(cookbookPhoto);
	}
	
	public List<Cookbook> findbyuserId(int userId,int beginIndex, int offset){
		return cookbookMapper.findbyuserId(userId, beginIndex, offset);
	}
	
	public void update(int cookbookLikenum,int cookbookVisitnum,String cookbookTip,String cookbookNutrition,String cookbookPhoto,String cookbookName,int userId,int cookbookTaste,int cookbookCuisine,int cookbookOccasion,int cookbookId) {
		cookbookMapper.update(cookbookLikenum,cookbookVisitnum,cookbookTip,cookbookNutrition,cookbookPhoto,cookbookName,userId,cookbookTaste,cookbookCuisine,cookbookOccasion,cookbookId);
	}
	
	public void delete(int cookbookId) {
		cookbookMapper.delete(cookbookId);
	}
	
	public void updatevisit(int cookbookId,int cookbookVisitnum) {
		cookbookMapper.updatevisit(cookbookId,cookbookVisitnum);
	}
	
	public void updatelike(int cookbookId,int cookbookLikenum) {
		cookbookMapper.updatelike(cookbookId,cookbookLikenum);
	}
	
	public Cookbook findbycookbookId(int cookbookId) {
		return cookbookMapper.findbycookbookId(cookbookId);
	}
	
	public List<Cookbook> findbyType(int cookbookTaste,int cookbookCuisine,int cookbookOccasion, int beginindex, int offset){
		return cookbookMapper.findbyType(cookbookTaste,cookbookCuisine,cookbookOccasion,beginindex, offset);
	}
	
	public List<Cookbook> findbyCuisine(int cookbookCuisine, int beginIndex, int offset){
		return cookbookMapper.findbyCuisine(cookbookCuisine, beginIndex, offset);
	}
	
	public List<Cookbook> findbyName(String cookbookName, int beginIndex, int offset){
		return cookbookMapper.findbyName(cookbookName, beginIndex, offset);
	}
	
	public List<Cookbook> getall(){
		return cookbookMapper.getall();
	}
}
