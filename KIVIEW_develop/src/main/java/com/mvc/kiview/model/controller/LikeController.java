package com.mvc.kiview.model.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.kiview.model.biz.LikeBiz;
import com.mvc.kiview.model.vo.FavoriteVo;
import com.mvc.kiview.model.vo.LikeVo;



@Controller //좋아요, 즐겨찾기 관련
public class LikeController {

   @Autowired
   private LikeBiz biz;
   
   private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
   
   @RequestMapping(value="/likeSubmit.do", method=RequestMethod.POST)
   public @ResponseBody HashMap<String, Object> likeSubmit(@RequestBody LikeVo vo) {
      HashMap<String, Object> resultMap = new HashMap<String,Object>(); 
     
      
         int resultFlag =0;
         
         int likeCount = biz.selectLikeCount(vo);
         
         System.out.println("likecount" + likeCount);
         
         if(likeCount > 0) {
            resultFlag =biz.likeDelete(vo);
            resultMap.put("resultMsg", "delete");
         }else {
            resultFlag =biz.likeInsert(vo);
            resultMap.put("resultMsg", "insert");
         }
         
         resultMap.put("resultFlag",  resultFlag);
         
     
      return resultMap;
   }
   
 //즐겨찾기
   @RequestMapping(value="/favoriteSubmit.do", method=RequestMethod.POST)
   public @ResponseBody HashMap<String, Object> favoriteSubmit(@RequestBody FavoriteVo vo){
      HashMap<String, Object> result = new HashMap<String,Object>();
      
      int resultSubmit = 0;
      logger.info("member_no : " + vo.getMember_no() + " , kinder_no : " + vo.getKinder_no());
      int favoriteCount = biz.selectFavoriteCount(vo);
      logger.info(String.valueOf(favoriteCount));
      
      if(favoriteCount > 0) {
         resultSubmit = biz.favoriteDelete(vo);
         result.put("resultMsg","delete");
         System.out.println(favoriteCount);
      } else {
         resultSubmit = biz.favoriteInsert(vo);
         result.put("resultMsg","insert");
         System.out.println(favoriteCount);
      }
      result.put("kinderCnt",biz.selectFavoriteCount(vo));
      System.out.println("KinderCnt22 : " + biz.selectFavoriteCount(vo));
      
      
      result.put("resultSubmit", resultSubmit);
      
      return result;
      
   }
   
   

   
}