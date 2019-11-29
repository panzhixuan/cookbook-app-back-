package com.example.demo.contorller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Ingredint;
import com.example.demo.model.Score;
import com.example.demo.service.CookbookService;
import com.example.demo.service.TasteService;
import com.example.demo.service.ScoreService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;

@RestController
@RequestMapping("/score")
public class ScoreController {
	@Resource
    private ScoreService scoreService;
	
	@Resource
    private CookbookService cookbookService;
	
	//获取评分（单条）
	@PostMapping("/get")
    public Result get(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    Score result=scoreService.get(userId,cookbookId);
	    if(result!=null) {
		   return ResultGenerator.genSuccessResult(result);
		}
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//获取评分（多条）
	@PostMapping("/getall")
    public Result getall(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
		int beginIndex = jsonObject.getInteger("beginIndex");
	    List<Score> result=scoreService.getall(userId, beginIndex, 6);
	    if(result!=null) {
		   return ResultGenerator.genSuccessResult(result);
		}
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//添加评分
	@PostMapping("/add")
    public Result add(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    int scoreNum = jsonObject.getInteger("scoreNum");
	    Score score=new Score();
	    score.setCookbookId(cookbookId);
	    score.setUserId(userId);
	    score.setScore(scoreNum);
	    scoreService.add(score);
		return ResultGenerator.genSuccessResult();
    }
	
	//删除评分
	@PostMapping("/delete")
    public Result delete(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    scoreService.deleteByUserIdAndCookBookId(userId, cookbookId);
		return ResultGenerator.genSuccessResult();
    }
}
