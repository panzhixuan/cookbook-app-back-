package com.example.demo.contorller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Comment;
import com.example.demo.model.Ingredint;
import com.example.demo.service.CommentService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;


@RestController
@RequestMapping("/comment")
public class CommentController {
	@Resource
    private CommentService commentService;
	
	//添加评论
	@PostMapping("/add")
    public Result add(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    int userId=jsonObject.getInteger("userId");
	    String commentInf=jsonObject.getString("commentInf");
	    Comment comment=new Comment();
	    comment.setCommentInf(commentInf);
	    comment.setCookbookId(cookbookId);
	    comment.setUserId(userId);
	    commentService.add(comment);
	    return ResultGenerator.genSuccessResult();
    }
	
	//获取评论
	@PostMapping("/get")
    public Result get(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    List<Comment> result=commentService.get(cookbookId);
	    if(result.size()!=0) {
		      return ResultGenerator.genSuccessResult(result);
		    }
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//删除评论
	@PostMapping("/delete")
    public Result delete(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    int userId=jsonObject.getInteger("userId");
	    commentService.delete(userId,cookbookId);
		return ResultGenerator.genSuccessResult();
    }
}
