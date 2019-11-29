package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	public String getemail(String email);
	
	public void register(User user);
	
	public User login(String userEmail,String userPassword);
	
	public void forgetpassword(String userEmail,String userPassword);
	
	public void update(int userId,int userTaste,int userCuisine,int userOccasion,String userName,String userAddress);
	
	public User getuserbyId(int userId);
	
	public int getTaste(int userId);
	
	public int getCuisine(int userId);
	
	public int getOccasion(int userId);
}