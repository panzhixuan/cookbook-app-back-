package com.example.demo.contorller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.CommentService;
import com.example.demo.service.OccasionService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;

@RestController
@RequestMapping("/occasion")
public class OccasionController {
	@Resource
    private OccasionService occasionService;
	
	//根据id查找名字
	@PostMapping("/IdfindName")
    public Result IdfindName(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
    	int Id=jsonObject.getInteger("occasionId");
    	String name=occasionService.IdfindName(Id);
        return ResultGenerator.genSuccessResult(name);
    }
	
	//根据名字查找id
	@PostMapping("/NamefindId")
    public Result NamefindId(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
    	String Name=jsonObject.getString("occasionName");
    	int id =occasionService.NamefindId(Name);
        return ResultGenerator.genSuccessResult(id);
    }
}
