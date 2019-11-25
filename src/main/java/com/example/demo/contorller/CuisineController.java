package com.example.demo.contorller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.CommentService;
import com.example.demo.service.CuisineService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;



@RestController
@RequestMapping("/cuisine")
public class CuisineController {
	@Resource
    private CuisineService cuisineService;
	
	//根据id查找名字
	@PostMapping("/IdfindName")
    public Result IdfindName(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
    	int Id=jsonObject.getInteger("cuisineId");
    	String name=cuisineService.IdfindName(Id);
        return ResultGenerator.genSuccessResult(name);
    }
	
	//根据名字查找id
	@PostMapping("/NamefindId")
    public Result NamefindId(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
    	String Name=jsonObject.getString("cuisineName");
    	int id =cuisineService.NamefindId(Name);
        return ResultGenerator.genSuccessResult(id);
    }
}
