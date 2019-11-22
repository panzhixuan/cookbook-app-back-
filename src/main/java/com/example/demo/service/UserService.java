package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
	public String getemail(String email);
	
	public void register(User user);
	
	public User login(String userEmail,String userPassword);
	
	public void forgetpassword(String userEmail,String userPassword);
	
	public void update(int userId,int userTaste,int userCuisine,int userOccasion,String userName,String userAddress);
	
	public User getuserbyId(int userId);
}
