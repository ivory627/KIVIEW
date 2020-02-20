package com.mvc.kiview.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/autosearch.do")
	@ResponseBody
	public List<KinderVo> autoSearch(Locale locale, Model model, String keyword) {    
	    
		List<KinderVo> list = biz.KinderList(keyword);
		//Map<String,Object> map = new HashMap<String, Object>();
		//map.put("name", list);
		//System.out.println(map);


	    return list;
	}
	

}
