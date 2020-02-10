package com.mvc.kiview.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller //카페관련
public class CafeController {
	
	@RequestMapping("/cafehome.do")
	public String cafe_home() {
		
		return "cafe_home";
	}
	
	
	
	

}
