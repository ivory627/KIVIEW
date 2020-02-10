package com.mvc.kiview.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //공지관련
public class NoticeController {
	
	@RequestMapping("/kiviewnotice.do")
	public String kiview_notice() {
		return "kiview_notice";
	}
	
	
	
}
