package com.example.demo.contorller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Likes;
import com.example.demo.model.Visit;
import com.example.demo.service.CommentService;
import com.example.demo.service.CookbookService;
import com.example.demo.service.LikesService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;

@RestController
@RequestMapping("/likes")
public class LikesController {
	@Resource
    private LikesService likesService;
	@Resource
    private CookbookService cookbookService;
	
	//获取收藏记录（单条）
	@PostMapping("/get")
    public Result get(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    Likes result=likesService.get(userId,cookbookId);
	    if(result!=null) {
		   return ResultGenerator.genSuccessResult(result);
		}
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//获取收藏记录（多条）
	@PostMapping("/getall")
    public Result getall(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
		int beginIndex = jsonObject.getInteger("beginIndex");
	    List<Likes> result=likesService.getall(userId, beginIndex, 6);
	    if(result!=null) {
		   return ResultGenerator.genSuccessResult(result);
		}
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//添加收藏记录
	@PostMapping("/add")
    public Result add(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    int cookbookLikenum=jsonObject.getInteger("cookbookLikenum");
	    Likes likes=new Likes();
	    likes.setCookbookId(cookbookId);
	    likes.setUserId(userId);
	    likesService.add(likes);
	    cookbookService.updatelike(cookbookId, cookbookLikenum+1);
		return ResultGenerator.genSuccessResult();
    }
	
	//删除收藏记录
	@PostMapping("/delete")
    public Result delete(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    int cookbookLikenum=jsonObject.getInteger("cookbookLikenum");
	    likesService.delete(userId,cookbookId);
	    cookbookService.updatelike(cookbookId, cookbookLikenum-1);
		return ResultGenerator.genSuccessResult();
    }
}
