package com.mvc.kiview.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.kiview.model.biz.ReviewBiz;

@Controller //리뷰관련
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewBiz biz;
	
	@RequestMapping("/reviewboard.do")
	public String reviewBoard() {
		
		return "kiview_reviewboard";
	}
	
	@RequestMapping("/reviewlist.do")
	public String list(Model model) {
		logger.info("SELECT reviewlist");
		model.addAttribute("list", biz.reviewList());
		return "kiview_reviewboard";
	}

}