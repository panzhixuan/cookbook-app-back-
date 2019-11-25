package com.example.demo.contorller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Ingredint;
import com.example.demo.service.CommentService;
import com.example.demo.service.IngredintService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;

@RestController
@RequestMapping("/ingredint")
public class IngredintController {
	@Resource
    private IngredintService ingredintService;
	
	//添加材料
	@PostMapping("/add")
    public Result add(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    String ingredintName=jsonObject.getString("ingredintName");
	    String ingredintNum=jsonObject.getString("ingredintNum");
	    Ingredint ingredint=new Ingredint();
	    ingredint.setCookbookId(cookbookId);
	    ingredint.setIngredintName(ingredintName);
	    ingredint.setIngredintNum(ingredintNum);
	    ingredintService.add(ingredint);
	    return ResultGenerator.genSuccessResult();
    }
	
	//获取材料
	@PostMapping("/get")
    public Result get(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    List<Ingredint> result=ingredintService.get(cookbookId);
	    if(result!=null) {
		   return ResultGenerator.genSuccessResult(result);
		}
		return ResultGenerator.genFailResult("没有找到");
    }
	
	//删除全部材料
	@PostMapping("/delete")
    public Result delete(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    ingredintService.delete(cookbookId);
	    return ResultGenerator.genSuccessResult();
    }
	
	//通过材料获取菜谱
	@PostMapping("/getCookbookList")
    public Result getCookbookList(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    String ingredintName = jsonObject.getString("ingredintName");
	    int beginIndex = jsonObject.getInteger("beginIndex");
	    List<Integer> result = ingredintService.getCookbookList(ingredintName, beginIndex, 6);
	    if(result!=null)
	    	return ResultGenerator.genSuccessResult(result);
	    return ResultGenerator.genFailResult("没有找到");
    }
}
