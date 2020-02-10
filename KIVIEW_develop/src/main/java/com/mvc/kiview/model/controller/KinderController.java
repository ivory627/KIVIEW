package com.mvc.kiview.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //검색관련
public class KinderController {
	
	@RequestMapping("/kindersearch.do")
	public String kindersearch() {
		
		return "kiview_search";
	}

}
