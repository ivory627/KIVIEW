package com.mvc.kiview.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.kiview.model.biz.KinderBiz;
import com.mvc.kiview.model.vo.KinderVo;

@Controller // 인덱스 관련된 컨트롤러
public class MainController {
	
	@Autowired
	private KinderBiz biz;

	@RequestMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/autosearch.do")
	@ResponseBody
	public List<KinderVo> autoSearch(String keyword) {    
	    
		List<KinderVo> list = biz.KinderList(keyword);

	    return list;
	}
	
	@RequestMapping("/mainsearch.do")
	public ModelAndView mainSearch(String keyword) {
		
		ModelAndView mav = new ModelAndView("kinder/kiview_Search_detail");
		mav.addObject("kindervo",biz.Kinderdetail(keyword));
		
		return mav;
	}
	

}
