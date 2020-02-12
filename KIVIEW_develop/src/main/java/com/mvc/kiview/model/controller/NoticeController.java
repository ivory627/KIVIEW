package com.mvc.kiview.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //공지관련
public class NoticeController {
	
	@RequestMapping("/kiviewnotice.do")
	public String kiview_notice() {
		return "kiview_notice";
	}
	
	@RequestMapping("/kiviewintro.do")
	public String kiview_intro() {
		return "kiview_intro";
	}
	
	@RequestMapping("/kiviewfaq.do")
	public String kiview_faq() {
		return "kiview_FAQ";
	}
	
	@RequestMapping("/kiviewdetail.do")
	public String kiview_detail() {
		return "kiview_notice_detail";
	}
	
	
	
	
	
	
	
}
