package com.example.demo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


//基于用户的协同过滤算法
public class RecommandAlgorithm {

//  public static void main(String[] args) {
//      Map<Integer, Map<Integer, Integer>> userPerfMap = new HashMap<Integer, Map<Integer, Integer>>();
//      Map<Integer, Integer> pref1 = new HashMap<Integer, Integer>();
//      pref1.put(1, 3);
//      pref1.put(2, 4);
//      pref1.put(3, 3);
//      pref1.put(4, 5);
//      pref1.put(5, 1);
//      pref1.put(6, 4);
//      userPerfMap.put(0, pref1);
//      Map<Integer, Integer> pref2 = new HashMap<Integer, Integer>();
//      pref2.put(1, 2);
//      pref2.put(2, 4);
//      pref2.put(3, 4);
//      pref2.put(4, 5);
//      pref2.put(5, 3);
//      pref2.put(6, 2);
//      userPerfMap.put(1, pref2);
//      Map<Integer, Integer> pref3 = new HashMap<Integer, Integer>();
//      pref3.put(1, 3);
//      pref3.put(2, 5);
//      pref3.put(3, 4);
//      pref3.put(4, 5);
//      pref3.put(5, 2);
//      pref3.put(6, 1);
//      userPerfMap.put(2, pref3);
//      Map<Integer, Integer> pref4 = new HashMap<Integer, Integer>();
//      pref4.put(1, 2);
//      pref4.put(2, 2);
//      pref4.put(3, 3);
//      pref4.put(4, 4);
//      pref4.put(5, 3);
//      pref4.put(6, 2);
//      userPerfMap.put(3, pref4);
//      Map<Integer, Integer> pref5 = new HashMap<Integer, Integer>();
//      pref5.put(1, 4);
//      pref5.put(2, 4);
//      pref5.put(3, 4);
//      pref5.put(4, 5);
//      pref5.put(5, 1);
//      pref5.put(6, 0);
//      userPerfMap.put(4, pref5);
//
//      Map<Integer, Double> simUserSimMap = new HashMap<Integer, Double>();
//      System.out.println("皮尔逊相关系数:");
//
//      for (Entry<Integer, Map<Integer, Integer>> userPerfEn : userPerfMap.entrySet()) {
//          Integer userName = userPerfEn.getKey();
//          if (userName != 5) {
//              double sim = getUserSimilar(pref5, userPerfEn.getValue());
//              System.out.println("p5与" + userName + "之间的相关系数:" + sim);
//              simUserSimMap.put(userName, sim);
//          }
//      }
//
//      Map<Integer, Map<Integer, Integer>> simUserObjMap = new HashMap<Integer, Map<Integer, Integer>>();
//      Map<Integer, Integer> pobjMap1 = new HashMap<Integer, Integer>();
//      pobjMap1.put(11, 3);
//      pobjMap1.put(12, 4);
//      pobjMap1.put(13, 3);
//      simUserObjMap.put(0, pobjMap1);
//      Map<Integer, Integer> pobjMap2 = new HashMap<Integer, Integer>();
//      pobjMap2.put(11, 5);
//      pobjMap2.put(12, 1);
//      pobjMap2.put(13, 2);
//      simUserObjMap.put(1, pobjMap2);
//      Map<Integer, Integer> pobjMap3 = new HashMap<Integer, Integer>();
//      pobjMap3.put(11, 2);
//      pobjMap3.put(12, 5);
//      pobjMap3.put(13, 5);
//      simUserObjMap.put(2, pobjMap3);
//
//      System.out.println("推荐结果:" + getRecommend(simUserObjMap, simUserSimMap));
//      
//      m(userPerfMap, simUserObjMap, 4);
//  }
  public  List<Entry<Integer, Double>> cal(Map<Integer, Map<Integer, Integer>> userPerfMap, Map<Integer, Map<Integer, Integer>> userPerfMapTORecommand, int userId) {
	  Map<Integer, Integer> prefOfUserId = userPerfMap.get(userId);
      Map<Integer, Double> simUserSimMap = new HashMap<Integer, Double>();
      System.out.println("皮尔逊相关系数:");

      for (Entry<Integer, Map<Integer, Integer>> userPerfEn : userPerfMap.entrySet()) {
          Integer userName = userPerfEn.getKey();
          if (userName != userId) {
              double sim = getUserSimilar(prefOfUserId, userPerfEn.getValue());
              System.out.println(userId + "与" + userName + "之间的相关系数:" + sim);
              simUserSimMap.put(userName, sim);
          }
      }
      
      
      //System.out.println("推荐结果:" + getRecommend(userPerfMapTORecommand, simUserSimMap, userId));
      return getRecommend(userPerfMapTORecommand, simUserSimMap, userId);
      
  }

  //Claculate Pearson Correlation Coefficient
  public  double getUserSimilar(Map<Integer, Integer> pm1, Map<Integer, Integer> pm2) {
      int n = 0;// 数量n
      int sxy = 0;// Σxy=x1*y1+x2*y2+....xn*yn
      int sx = 0;// Σx=x1+x2+....xn
      int sy = 0;// Σy=y1+y2+...yn
      int sx2 = 0;// Σx2=(x1)2+(x2)2+....(xn)2
      int sy2 = 0;// Σy2=(y1)2+(y2)2+....(yn)2
      for (Entry<Integer, Integer> pme : pm1.entrySet()) {
          Integer key = pme.getKey();
          Integer x = pme.getValue();
          Integer y = pm2.get(key);
          if (x != null && y != null) {
              n++;
              sxy += x * y;
              sx += x;
              sy += y;
              sx2 += Math.pow(x, 2);
              sy2 += Math.pow(y, 2);
          }
      }
      // p=(Σxy-Σx*Σy/n)/Math.sqrt((Σx2-(Σx)2/n)(Σy2-(Σy)2/n));
      double sd = sxy - sx * sy / n;
      double sm = Math.sqrt((sx2 - Math.pow(sx, 2) / n) * (sy2 - Math.pow(sy, 2) / n));
      return Math.abs(sm == 0 ? 1 : sd / sm);
  }

  //获取推荐结果
  public  List<Entry<Integer, Double>> getRecommend(Map<Integer, Map<Integer, Integer>> simUserObjMap,
          Map<Integer, Double> simUserSimMap, int userId) {
	  Map<Integer, Integer> itemScoreOfUser = simUserObjMap.get(userId);
      Map<Integer, Double> objScoreMap = new HashMap<Integer, Double>();
      for (Entry<Integer, Map<Integer, Integer>> simUserEn : simUserObjMap.entrySet()) {
          Integer user = simUserEn.getKey();
          if(user == userId) {
        	  continue;
          }
          double sim = simUserSimMap.get(user);
          for (Entry<Integer, Integer> simObjEn : simUserEn.getValue().entrySet()) {
        	  if(itemScoreOfUser.containsKey(simObjEn.getKey())) {
        		  System.out.println("已经评价了，忽略: " + simObjEn.getKey());
        		  continue;
        	  }
              double objScore = sim * simObjEn.getValue();//加权（相似度*评分）
              Integer objName = simObjEn.getKey();
              if (objScoreMap.get(objName) == null) {
                  objScoreMap.put(objName, objScore);
              } else {
                  double totalScore = objScoreMap.get(objName);
                  objScoreMap.put(objName, totalScore + objScore);//将所有用户的加权评分作为最后的推荐结果数据
              }
          }
      }
      List<Entry<Integer, Double>> enList = new ArrayList<Entry<Integer, Double>>(objScoreMap.entrySet());
      Collections.sort(enList, new Comparator<Map.Entry<Integer, Double>>() {//排序
          public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
              Double a = o1.getValue() - o2.getValue();
              if (a == 0) {
                  return 0;
              } else if (a > 0) {
                  return 1;
              } else {
                  return -1;
              }
          }
      });
      for (Entry<Integer, Double> entry : enList) {
          System.out.println(entry.getKey()+"的加权推荐值:"+entry.getValue());
      }
      return enList;
      //return enList.get(enList.size() - 1).getKey();//返回推荐结果
  }
}

