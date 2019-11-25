package com.example.demo.contorller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Cookbook;
import com.example.demo.model.User;
import com.example.demo.service.CommentService;
import com.example.demo.service.CookbookService;
import com.example.demo.util.Imageutil;
import com.example.demo.util.Result;
import com.example.demo.util.ResultGenerator;
import com.example.demo.util.Uploadphoto;
import com.example.demo.service.ScoreService;
import com.example.demo.model.Score;
import com.example.demo.util.RecommandAlgorithm;

@RestController
@RequestMapping("/cookbook")
public class CookbookController {
	@Resource
    private CookbookService cookbookService;
	
	@Resource
	private ScoreService scoreService;
	
	//上传头像
	@PostMapping("/uploadcover")
    public Result uploadcover(@RequestBody String body) {
		System.out.println("here1");
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
	
	//添加菜谱
	@PostMapping("/add")
    public Result add(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookLikenum=jsonObject.getInteger("cookbookLikenum");
	    int cookbookVisitnum=jsonObject.getInteger("cookbookVisitnum");
	    String cookbookTip=jsonObject.getString("cookbookTip");
	    String cookbookNutrition=jsonObject.getString("cookbookNutrition");
	    String cookbookPhoto=jsonObject.getString("cookbookPhoto");
	    String cookbookName=jsonObject.getString("cookbookName");
	    int userId=jsonObject.getInteger("userId");
	    int cookbookTaste=jsonObject.getInteger("cookbookTaste");
	    int cookbookCuisine=jsonObject.getInteger("cookbookCuisine");
	    int cookbookOccasion=jsonObject.getInteger("cookbookOccasion");
	    cookbookService.add(cookbookLikenum,cookbookVisitnum,cookbookTip,cookbookNutrition,cookbookPhoto,cookbookName,userId,cookbookTaste,cookbookCuisine,cookbookOccasion);
	    return ResultGenerator.genSuccessResult();
    }
	
	//更新菜谱
	@PostMapping("/update")
    public Result update(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int cookbookId=jsonObject.getInteger("cookbookId");
	    int cookbookLikenum=jsonObject.getInteger("cookbookLikenum");
	    int cookbookVisitnum=jsonObject.getInteger("cookbookVisitnum");
	    String cookbookTip=jsonObject.getString("cookbookTip");
	    String cookbookNutrition=jsonObject.getString("cookbookNutrition");
	    String cookbookPhoto=jsonObject.getString("cookbookPhoto");
	    String cookbookName=jsonObject.getString("cookbookName");
	    int userId=jsonObject.getInteger("userId");
	    int cookbookTaste=jsonObject.getInteger("cookbookTaste");
	    int cookbookCuisine=jsonObject.getInteger("cookbookCuisine");
	    int cookbookOccasion=jsonObject.getInteger("cookbookOccasion");
	    cookbookService.update(cookbookLikenum,cookbookVisitnum,cookbookTip,cookbookNutrition,cookbookPhoto,cookbookName,userId,cookbookTaste,cookbookCuisine,cookbookOccasion,cookbookId);
	    return ResultGenerator.genSuccessResult();
    }
	
	//通过图片名称查找菜谱
	@PostMapping("/findbyPhoto")
    public Result findbyPhoto(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		String cookbookPhoto=jsonObject.getString("cookbookPhoto");
	    Cookbook result=cookbookService.findbyPhoto(cookbookPhoto);
	    if(result!=null) {
	      return ResultGenerator.genSuccessResult(result);
	    }
	    return ResultGenerator.genFailResult("没有找到");
    }
	
	//通过菜谱图片名称获取菜谱图片
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
    
	//根据用户id获取菜谱
	@PostMapping("/findbyuserId")
    public Result findbyuserId(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId=jsonObject.getInteger("userId");
		int beginIndex = jsonObject.getInteger("beginIndex");
	    List<Cookbook> result=cookbookService.findbyuserId(userId, beginIndex, 6);
	    if(result.size()!=0) {
	      return ResultGenerator.genSuccessResult(result);
	    }
	    return ResultGenerator.genFailResult("没有找到");
    }
	
	//删除菜谱
	@PostMapping("/delete")
    public Result delete(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    cookbookService.delete(cookbookId);
	    return ResultGenerator.genSuccessResult();
    }
	
	//更新浏览数
	@PostMapping("/updatevisit")
    public Result updatevisit(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    int cookbookVisitnum=jsonObject.getInteger("cookbookVisitnum");
	    cookbookService.updatevisit(cookbookId,cookbookVisitnum);
	    return ResultGenerator.genSuccessResult();
    }
	
	//更新收藏数
	@PostMapping("/updatelike")
    public Result updatelike(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    int cookbookId=jsonObject.getInteger("cookbookId");
	    int cookbookLikenum=jsonObject.getInteger("cookbookLikenum");
	    cookbookService.updatelike(cookbookId,cookbookLikenum);
	    return ResultGenerator.genSuccessResult();
    }
	
	//通过菜谱Id查找菜谱
	@PostMapping("/findbycookbookId")
    public Result findbycookbookId(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int cookbookId=jsonObject.getInteger("cookbookId");
	    Cookbook result=cookbookService.findbycookbookId(cookbookId);
	    if(result!=null) {
	      return ResultGenerator.genSuccessResult(result);
	    }
	    return ResultGenerator.genFailResult("没有找到");
    }
	
	//通过菜谱三属性查找菜谱
	@PostMapping("/findbyType")
    public Result findbyType(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int cookbookTaste=jsonObject.getInteger("cookbookTaste");
		int cookbookCuisine=jsonObject.getInteger("cookbookCuisine");
		int cookbookOccasion=jsonObject.getInteger("cookbookOccasion");
		int cookbookbeginindex = jsonObject.getInteger("beginIndex");
	    List<Cookbook> result=cookbookService.findbyType(cookbookTaste,cookbookCuisine,cookbookOccasion, cookbookbeginindex, 6);
	    if(result!=null) {
	      return ResultGenerator.genSuccessResult(result);
	    }
	    return ResultGenerator.genFailResult("没有找到");
    }
	
	//通过菜谱菜系查找菜谱
	@PostMapping("/findbyCuisine")
    public Result findbyCuisine(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int cookbookCuisine=jsonObject.getInteger("cookbookCuisine");
		int beginIndex = jsonObject.getInteger("beginIndex");
	    List<Cookbook> result=cookbookService.findbyCuisine(cookbookCuisine, beginIndex, 6);
	    if(result!=null) {
	      return ResultGenerator.genSuccessResult(result);
	    }
	    return ResultGenerator.genFailResult("没有找到");
    }
	
	//通过菜谱名字查找菜谱
	@PostMapping("/findbyName")
    public Result findbyName(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		String cookbookName=jsonObject.getString("cookbookName");
		int beginIndex = jsonObject.getInteger("beginIndex");
	    List<Cookbook> result=cookbookService.findbyName(cookbookName, beginIndex, 6);
	    if(result!=null) {
	      return ResultGenerator.genSuccessResult(result);
	    }
	    return ResultGenerator.genFailResult("没有找到");
    }
	
	//获得全部菜谱
	@PostMapping("/getall")
    public Result getall(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
	    List<Cookbook> result=cookbookService.getall();
	    if(result!=null) {
	      return ResultGenerator.genSuccessResult(result);
	    }
	    return ResultGenerator.genFailResult("没有找到");
    }
	//获得全部菜谱
	@PostMapping("/recommand")
    public Result recommand(@RequestBody String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		int userId = jsonObject.getInteger("userId");
		
		List<Score> allScore = scoreService.getAllScore();
		
		System.out.println(allScore.toString());
		
		Map<Integer, Map<Integer, Integer>> userItemScore = new HashMap<Integer, Map<Integer, Integer>>();
		Map<Integer, Map<Integer, Integer>> userItemScoreToRecommand = new HashMap<Integer, Map<Integer, Integer>>();
		
		for(Score s : allScore) {
			Map<Integer, Integer> itemScore = userItemScore.get(s.getUserId());
			if(itemScore == null) {
				itemScore = new HashMap<Integer, Integer>();
				itemScore.put(s.getCookbookId(), s.getScore());
				userItemScore.put(s.getUserId(), itemScore);
			}
			else {
				itemScore.put(s.getCookbookId(), s.getScore());
			}
		}
		
		System.out.println(userItemScore.toString());
		
		RecommandAlgorithm recommand = new RecommandAlgorithm();
		
		List<Entry<Integer, Double>> result = recommand.cal(userItemScore, userItemScore, userId);
		
		//recommand.cal(userItemScore, userItemScore, userId);
		
		
		
		
		
	    //List<Cookbook> result=cookbookService.getall();
	    if(result!=null) {
	      return ResultGenerator.genSuccessResult(result);
	    }
	    return ResultGenerator.genFailResult("没有找到");
    }
}
