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
	
	@RequestMapping("/kiview_myactivity.do")
	public String myactivity() {
		return "kiview_myactivity";
	}
	
	@RequestMapping("/kiview_mypage.do")
	public String mypage() {
		return "kiview_mypage";
	}
	
	@Autowired
	private LikeBiz biz;
	
	@RequestMapping("/likeSubmit.do")
	public @ResponseBody HashMap<String, Object> likeSubmit(int reviewSeq, HttpServletResponse response) {
		HashMap<String, Object> resultMap = new HashMap<String,Object>(); 
		LikeVo vo = new LikeVo();
		
		try{
			int resultFlag = 0;
			/**
			 * 여기에 member_no 넣어줘야함 로그인 가능 한 시점부터 세션에 로그인한 사용자 정보 있는데 거기서 빼서 넣어야 해
			 */
			//vo.setMember_no(member_no);
			vo.setMember_no(1); 
			vo.setReview_no(reviewSeq);
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
