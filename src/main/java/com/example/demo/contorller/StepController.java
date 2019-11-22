package com.example.demo.contorller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Ingredint;
import com.example.demo.model.Step;
import com.example.demo.service.CommentService;
import com.example.demo.service.StepService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;

@RestController
@RequestMapping("/step")
public class StepController {
	@Resource
    private StepService stepService;
	
	//添加步骤
	@PostMapping("/add")
    public Result add(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    String stepInf=jsonObject.getString("stepInf");
	    Step step=new Step();
	    step.setCookbookId(cookbookId);
	    step.setStepInf(stepInf);
	    stepService.add(step);
	    return ResultGenerator.genSuccessResult();
    }
	
	//获取步骤
	@PostMapping("/get")
    public Result get(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    List<Step> result=stepService.get(cookbookId);
	    if(result!=null) {
		   return ResultGenerator.genSuccessResult(result);
		}
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//删除全部步骤
	@PostMapping("/delete")
    public Result delete(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    stepService.delete(cookbookId);
	    return ResultGenerator.genSuccessResult();
    }
}
