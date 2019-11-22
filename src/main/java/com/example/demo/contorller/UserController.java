package com.example.demo.contorller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.User;
import com.example.demo.service.TasteService;
import com.example.demo.service.UserService;
import com.example.demo.util.Imageutil;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;
import com.example.demo.util.Uploadphoto;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
    private UserService userService;
	
	//上传头像
	@PostMapping("/uploadheader")
    public Result uploadheader(@RequestBody String body) {
		System.out.println("here");
		JSONObject jsonObject = JSONObject.parseObject(body);
		JSONArray list1 = (JSONArray) jsonObject.get("photo");
        byte[] b = new byte[list1.size()];
        for (int j = 0; j < list1.size(); j++) {
            b[j] = (byte)(int) list1.getInteger(j);
        }
    	String name=jsonObject.getString("name");
    	boolean result=Uploadphoto.byteToFile(b, name);
        return ResultGenerator.genSuccessResult(result);
    }
	
	//检测邮箱
	@PostMapping("/getemail")
    public Result getemail(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		String email = jsonObject.getString("email");
    	String result= userService.getemail(email);
    	if(result!=null) {
          return ResultGenerator.genSuccessResult(result);
    	}
    	  return ResultGenerator.genFailResult(result);
    }
	
	//登录
	@PostMapping("/login")
    public Result login(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		String email = jsonObject.getString("userEmail");
		String password = jsonObject.getString("userPassword");
    	User result=userService.login(email,password);
    	if(result!=null) {
          return ResultGenerator.genSuccessResult(result);
    	}
    	  return ResultGenerator.genFailResult("用户或密码不正确");
    }
	
	//修改密码
	@PostMapping("/forgetpassword")
    public Result forgetpassword(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		String email = jsonObject.getString("userEmail");
		String password = jsonObject.getString("userPassword");
    	userService.forgetpassword(email,password);
    	return ResultGenerator.genSuccessResult();
    }
	
	//注册
	@PostMapping("/register")
    public Result register(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		String userEmail=jsonObject.getString("userEmail");
	    String userPassword=jsonObject.getString("userPassword");
	    Integer userTaste=jsonObject.getInteger("userTaste");
	    Integer userCuisine=jsonObject.getInteger("userCuisine");
	    Integer userOccasion=jsonObject.getInteger("userOccasion");
	    String userPhoto=jsonObject.getString("userPhoto");
	    String userName=jsonObject.getString("userName");
	    String userAddress=jsonObject.getString("userAddress");
	    User user=new User();
	    user.setUserEmail(userEmail);
	    user.setUserPassword(userPassword);
	    user.setUserTaste(userTaste);
	    user.setUserCuisine(userCuisine);
	    user.setUserOccasion(userOccasion);
	    user.setUserPhoto(userPhoto);
	    user.setUserName(userName);
	    user.setUserAddress(userAddress);
	    userService.register(user);
	    return ResultGenerator.genSuccessResult();
    }
	
	//通过用户图片名称获取头像
    @PostMapping("/findphoto")
    public Result panfindphoto(@RequestBody String body) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        String name = jsonObject.getString("photo");
        byte[] result=Imageutil.getImage(name);
        List<Byte> result1=new ArrayList();
        for(int i=0;i<result.length;i++) {
        	result1.add(result[i]);
        }
        return ResultGenerator.genSuccessResult(result1);
    }
    
    //更新用户信息
    @PostMapping("/update")
    public Result update(@RequestBody String body) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        Integer userId=jsonObject.getInteger("userId");
        Integer userTaste=jsonObject.getInteger("userTaste");
	    Integer userCuisine=jsonObject.getInteger("userCuisine");
	    Integer userOccasion=jsonObject.getInteger("userOccasion");
	    String userName=jsonObject.getString("userName");
	    String userAddress=jsonObject.getString("userAddress");
	    userService.update(userId,userTaste,userCuisine,userOccasion,userName,userAddress);
        return ResultGenerator.genSuccessResult();
    }
    
	//通过用户id获取用户
	@PostMapping("/getuserbyId")
    public Result getuserbyId(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
		User result=userService.getuserbyId(userId);
    	if(result!=null) {
          return ResultGenerator.genSuccessResult(result);
    	}
    	  return ResultGenerator.genFailResult("获取用户失败");
    }
}
