package com.mvc.kiview.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.kiview.model.biz.ReviewBiz;
import com.mvc.kiview.model.vo.KinderVo;
import com.mvc.kiview.model.vo.ReviewVo;

@Controller //리뷰관련
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewBiz biz;
	
	@RequestMapping("/reviewboard.do")
	public String list(Model model) {
		logger.info("ReviewController : REVIEW LIST");
		
		
		model.addAttribute("list", biz.reviewList());
		System.out.println(biz.reviewList());
		return "review/kiview_reviewboard";
	}
	
	@RequestMapping("/reviewInsert.do")
	public String reviewInsert(ReviewVo vo) {
		logger.info("ReviewController : INSERT REVIEW");
		
		int res = biz.reviewInsert(vo);
		
		if(res > 0) {
			return "redirect:reviewboard.do";
		} else {
			return "redirect:reviewboard.do";
		}
	}
	
	@RequestMapping("/reviewUpdate.do")
	public String reviewUpdate(ReviewVo vo) {
		logger.info("ReviewController : UPDATE RES");
		
		int res = biz.reviewUpdate(vo);
		
		if(res > 0) {
			return "redirect:reviewboard.do";
		} else {
			return "redirect:reviewboard.do";
		}
	}
	
	@RequestMapping("/reviewDelete.do")
	public String reviewDelete(int review_no) {
		logger.info("ReviewController : DELETE REVIEW");
		
		int res = biz.reviewDelete(review_no);
		
		if(res > 0) {
			return "redirect:reviewboard.do";
		} else {
			System.out.println("ReviewController : FAIL ---- DELETE");
			return "redirect:reviewboard.do";
		}
	}
	
	@RequestMapping("/reviewselect.do")
	@ResponseBody //json으로 바꿔서 해 주는 역할
	public Map review_select(int review_no) {
		ReviewVo review = biz.reviewSelect(review_no);
		System.out.println(review);
		Map map = new HashMap();
		map.put("review", review);
		
		return map;
		
	}
	
	@RequestMapping("/searchkinder.do")
	@ResponseBody
	public Map kinderSearch(String keyword) {
		
		List<KinderVo> kinder = biz.kinderSearch(keyword);
		
		Map map = new HashMap();
		map.put("kinder", kinder);
		
		
		
		return map;
	}
	
	@RequestMapping("/searchkinder2.do")
	@ResponseBody
	public Map kinderSearch2(String kinder_name) {
		KinderVo kinder = biz.kinderSearch2(kinder_name);
		System.out.println(kinder);
		Map map = new HashMap();
		map.put("kinder",kinder);
		
		return map;
	}
	
	@RequestMapping("/reviewsearch.do")
	public String reviewSearch(@Param("value=type") String type, @Param("value=keyword") String keyword, Model model){
		Map map = new HashMap();
		map.put("type", type);
		map.put("keyword",keyword);
		
		
		List<ReviewVo> list = biz.reviewSearch(map); 
		model.addAttribute("list",list);
		model.addAttribute("keyword", keyword);
		
		return "review/kiview_reviewboard";
	}
	
	

}