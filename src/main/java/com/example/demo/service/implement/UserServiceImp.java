package com.example.demo.service.implement;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService{
	@Resource
    private UserMapper userMapper;
	
	public String getemail(String email) {
		return userMapper.getemail(email);
	}
	
	public void register(User user) {
		userMapper.register(user);
	}
	
	public User login(String userEmail,String userPassword) {
		return userMapper.login(userEmail,userPassword);
	}
	
	public void forgetpassword(String userEmail,String userPassword) {
		userMapper.forgetpassword(userEmail,userPassword);
	}
	
	public void update(int userId,int userTaste,int userCuisine,int userOccasion,String userName,String userAddress) {
		userMapper.update(userId,userTaste,userCuisine,userOccasion,userName,userAddress);
	}
	
	public User getuserbyId(int userId) {
		return userMapper.getuserbyId(userId);
	}
}
