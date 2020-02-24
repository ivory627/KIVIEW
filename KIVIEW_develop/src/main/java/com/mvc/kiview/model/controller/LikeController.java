package com.mvc.kiview.model.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.kiview.model.biz.LikeBiz;
import com.mvc.kiview.model.vo.LikeVo;



@Controller //좋아요, 즐겨찾기 관련
public class LikeController {

   @Autowired
   private LikeBiz biz;
   
   @RequestMapping("/likeSubmit.do")
   public @ResponseBody HashMap<String, Object> likeSubmit(int review_no, int member_no, HttpServletResponse response) {
      HashMap<String, Object> resultMap = new HashMap<String,Object>(); 
      LikeVo vo = new LikeVo();
      
      try{
         int resultFlag = 0;
         
         vo.setMember_no(member_no); 
         vo.setReview_no(review_no);
         int likeCount = biz.selectLikeCount(vo);
         
         System.out.println(likeCount);
         
         if(likeCount > 0) {
            resultFlag =biz.likeDelete(vo);
            resultMap.put("resultMsg", "delete");
         }else {
            resultFlag =biz.likeInsert(vo);
            resultMap.put("resultMsg", "insert");
         }
         
         resultMap.put("resultFlag",  resultFlag);
         
      }catch(Exception e ) {
         
      }
      return resultMap;
   }
   
}