package com.example.demo.contorller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Ingredint;
import com.example.demo.model.Visit;
import com.example.demo.service.CookbookService;
import com.example.demo.service.TasteService;
import com.example.demo.service.VisitService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;

@RestController
@RequestMapping("/visit")
public class VisitController {
	@Resource
    private VisitService visitService;
	
	@Resource
    private CookbookService cookbookService;
	
	//获取浏览记录（单条）
	@PostMapping("/get")
    public Result get(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    Visit result=visitService.get(userId,cookbookId);
	    if(result!=null) {
		   return ResultGenerator.genSuccessResult(result);
		}
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//获取浏览记录（多条）
	@PostMapping("/getall")
    public Result getall(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
		int beginIndex = jsonObject.getInteger("beginIndex");
	    List<Visit> result=visitService.getall(userId, beginIndex, 6);
	    if(result!=null) {
		   return ResultGenerator.genSuccessResult(result);
		}
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//添加浏览记录
	@PostMapping("/add")
    public Result add(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    int cookbookVisitnum=jsonObject.getInteger("cookbookVisitnum");
	    Visit visit=new Visit();
	    visit.setCookbookId(cookbookId);
	    visit.setUserId(userId);
	    visitService.add(visit);
	    cookbookService.updatevisit(cookbookId, cookbookVisitnum+1);
		return ResultGenerator.genSuccessResult();
    }
}
