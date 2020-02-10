package com.mvc.kiview.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //리뷰관련
public class ReviewController {
	
	@RequestMapping("/reviewboard.do")
	public String reviewBoard() {
		
		return "kiview_reviewboard";
	}

}
