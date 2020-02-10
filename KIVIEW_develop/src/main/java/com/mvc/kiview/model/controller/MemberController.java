package com.mvc.kiview.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller //회원관련
public class MemberController {
	
	@RequestMapping("/kiviewlogin.do")
	public String kiview_login() {
		return "kiview_login";
	}

	
}
