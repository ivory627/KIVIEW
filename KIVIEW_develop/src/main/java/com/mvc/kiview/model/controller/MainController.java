package com.mvc.kiview.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.kiview.model.biz.KinderBiz;
import com.mvc.kiview.model.vo.Criteria;
import com.mvc.kiview.model.vo.KinderVo;
import com.mvc.kiview.model.vo.PageMaker;

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
	public ModelAndView mainSearch(String keyword,Criteria cri,Integer kinder_no) {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		ModelAndView mav = new ModelAndView("kinder/kiview_Search_detail");
		if(keyword!=null ) {
			mav.addObject("kindervo",biz.Kinderdetail(keyword));			
			mav.addObject("reviewvo",biz.ReviewList(biz.Kinderdetail(keyword).getKinder_no(),cri));
			pageMaker.setTotalCount(biz.ReviewCnt(biz.Kinderdetail(keyword).getKinder_no()));
		}else {
			mav.addObject("kindervo", biz.Kinderdetail(kinder_no));
			mav.addObject("reviewvo",biz.ReviewList(kinder_no,cri));
			pageMaker.setTotalCount(biz.ReviewCnt(kinder_no));

		}
		mav.addObject("pageMaker", pageMaker);
		
		return mav;
	}
	

}
