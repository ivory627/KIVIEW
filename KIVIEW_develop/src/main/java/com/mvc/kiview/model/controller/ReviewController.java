package com.mvc.kiview.model.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.kiview.model.biz.ReviewBiz;
import com.mvc.kiview.model.vo.LikeVo;
import com.mvc.kiview.model.vo.ReviewVo;

@Controller //리뷰관련
public class ReviewController {
	
	@Autowired
	private ReviewBiz biz;
	
	@RequestMapping("/reviewboard.do")
	public String reviewBoard(Model model) {
		
		List<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		LikeVo vo = new LikeVo();
		vo.setMember_no(1);
		reviewList = biz.reviewList(vo);
		
		
		model.addAttribute("reviewList", reviewList);
		return "kiview_reviewboard";
	}

}
