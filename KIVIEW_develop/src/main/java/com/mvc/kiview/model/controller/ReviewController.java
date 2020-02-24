package com.mvc.kiview.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.kiview.model.biz.ReviewBiz;
import com.mvc.kiview.model.vo.ReviewVo;

@Controller //리뷰관련
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewBiz biz;
	/*
	@RequestMapping("/reviewboard.do")
	public String reviewBoard() {
		
		return "kiview_reviewboard";
	}
	*/
	
	@RequestMapping("/reviewboard.do")
	public String list(Model model) {
		logger.info("ReviewController : REVIEW LIST");
		model.addAttribute("list", biz.reviewList());
		return "kiview_reviewboard";
	}
	
	@RequestMapping("/reviewInsert.do")
	public String reviewInsert(ReviewVo vo) {
		logger.info("ReviewController : INSERT REVIEW");
		
		int res = biz.reviewInsert(vo);
		System.out.println("insert" + vo);
		
		if(res > 0) {
			return "redirect:reviewboard.do";
		} else {
			return "redirect:reviewboard.do";
		}
	}
	
	@RequestMapping("/reviewUpdate.do")
	public String reviewUpdate(ReviewVo vo) {
		logger.info("ReviewController : UPDATE RES");
		
		int res = biz.reviewUpdate(vo);
		
		if(res > 0) {
			return "redirect:reviewboard.do";
		} else {
			return "redirect:reviewboard.do";
		}
	}
	
	@RequestMapping("/reviewDelete.do")
	public String reviewDelete(int review_no) {
		logger.info("ReviewController : DELETE REVIEW");
		System.out.println(review_no);
		
		int res = biz.reviewDelete(review_no);
		
		if(res > 0) {
			return "redirect:reviewboard.do";
		} else {
			System.out.println("ReviewController : FAIL ---- DELETE");
			return "redirect:reviewboard.do";
		}
	}

}