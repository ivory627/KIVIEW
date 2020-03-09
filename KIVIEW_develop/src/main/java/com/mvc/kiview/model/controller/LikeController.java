package com.mvc.kiview.model.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.kiview.model.biz.CafeBiz;
import com.mvc.kiview.model.biz.LikeBiz;

import com.mvc.kiview.model.vo.CafeBoardVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.CafeVo;
import com.mvc.kiview.model.vo.FavoriteVo;
import com.mvc.kiview.model.vo.KinderVo;

import com.mvc.kiview.model.vo.LikeVo;
import com.mvc.kiview.model.vo.ReviewVo;



@Controller //좋아요, 즐겨찾기 관련
public class LikeController {

	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
   
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
         LikeVo reviewCntVo = new LikeVo();
         reviewCntVo.setReview_no(vo.getReview_no());
         resultMap.put("reviewCnt", biz.selectLikeCount(reviewCntVo));
         System.out.println("reviewCnt: "+biz.selectLikeCount(reviewCntVo));
         
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
   
   
   
   @Autowired
   private CafeBiz biz_cafe;
   
   
   //마이페이지 - 회원활동
   @RequestMapping("/kiviewmyactivity.do")
   public String myactivity(Model model, String member_id) {
	 //내가 쓴 리뷰
	  List<ReviewVo> review = biz.myReview(member_id);
	  model.addAttribute("review",review);
	  
	  //내가 쓴  카페 글
	  List<CafeBoardVo> board = biz.myBoard(member_id);
	  model.addAttribute("board",board);
	  
	  List<CafeVo> cafe = biz_cafe.cafe_selectAll();
	  model.addAttribute("cafe",cafe);
	  
	  List<CafeMenuVo> menu = biz.myMenu();
	  model.addAttribute("menu",menu);
	  System.out.println(menu);
	  System.out.println(board);
	  
	  
	  //나의 즐겨찾기
	  List<KinderVo> favorite = biz.myFavorite(member_id);
	  model.addAttribute("favorite", favorite);
      
      return "member/kiview_myactivity";
   }


   
}