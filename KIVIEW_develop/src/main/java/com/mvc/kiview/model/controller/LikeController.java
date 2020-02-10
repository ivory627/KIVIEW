package com.mvc.kiview.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller //좋아요, 즐겨찾기 관련
public class LikeController {
	
	@RequestMapping("/myactivity.do")
	public String myactivity() {
		return "kiview_myactivity";
	}
	
	@RequestMapping("/mypage.do")
	public String mypage() {
		return "kiview_mypage";
	}
	
	
}
