package com.mvc.kiview.model.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.kiview.model.biz.LikeBiz;
import com.mvc.kiview.model.vo.LikeVo;



@Controller //좋아요, 즐겨찾기 관련
public class LikeController {

   @Autowired
   private LikeBiz biz;
   
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
   

   
}