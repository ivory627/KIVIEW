package com.mvc.kiview.model.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.kiview.model.biz.KinderBiz;
import com.mvc.kiview.model.vo.KinderVo;
import com.mvc.kiview.model.vo.ProvinceVo;

@Controller //검색관련
public class KinderController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private KinderBiz biz;
	
	@RequestMapping("/kindersearch.do")
	public String kindersearch(Model model) {
		logger.info("KINDER SEARCH");
		model.addAttribute("sido",biz.ProvinceList());
		
		return "kinder/kiview_search";
	}
	
	@RequestMapping("/searchdetail.do")
	public String searchdetail(Model model, int kinder_no) {
		logger.info("KINDER SEARCH DETAIL");
		//System.out.println(kinder_no);
		model.addAttribute("kindervo",biz.Kinderdetail(kinder_no));
		return "kinder/kiview_Search_detail";
	}
	
	@RequestMapping("/ajaxsigungu.do")
	@ResponseBody
	public List<ProvinceVo> ajaxsigungu(@RequestBody String province){

		//System.out.println(province);
		List<ProvinceVo> list = biz.CityList(province);
		//System.out.println(list);

		return list;
	}
	
	@RequestMapping("/ajaxdong.do")
	@ResponseBody
	public List<ProvinceVo> ajaxdong(@RequestBody String city){
		
		//System.out.println(city);
		List<ProvinceVo> list = biz.TownList(city);
		//System.out.println(list);
		
		return list;
	}
	
	@RequestMapping("/localsearch.do")
	public ModelAndView localSearch(ProvinceVo vo) {
		
		logger.info("LOCAL SEARCH");
		
		ModelAndView mav = new ModelAndView("kiview_search");
		mav.addObject("sido",biz.ProvinceList());
		
		if(vo.getTown()==null&&vo.getTown()=="") {
			vo = new ProvinceVo(vo.getProvince(),vo.getCity());
			mav.addObject("localvo",biz.LocalSerach(vo));
			mav.addObject("vo",vo);
			//System.out.println(biz.LocalSerach(vo));
		}else {
			vo = new ProvinceVo(vo.getProvince(),vo.getCity(),vo.getTown());
			mav.addObject("localvo",biz.LocalSerach(vo));
			mav.addObject("vo",vo);
			//System.out.println(biz.LocalSerach(vo));
		}
		
		
		return mav;
	}
	
	@RequestMapping("/namesearch.do")
	public ModelAndView nameSearch(String name) {
		
		logger.info("NAME SEARCH");
		//System.out.println(name);
		
		ModelAndView mav = new ModelAndView("kiview_search");
		mav.addObject("sido",biz.ProvinceList());
		mav.addObject("namevo",biz.NameSearch(name));
		
		return mav;
	}
	
	@RequestMapping("/ajaxtypesearch.do")
	@ResponseBody
	public List<KinderVo> typeSearch(@RequestBody HashMap<String, String> map){
		
		//System.out.println(map);
		List<KinderVo> list = biz.TypeSearch(map);
		//System.out.println(list.size());
		
		return list;
	}
	
	@RequestMapping("/ajaxmap.do")
	@ResponseBody
	public List<KinderVo> mapSearch(@RequestBody HashMap<String,String> map){
		List<KinderVo> list = biz.mapSearch(map);
		return list;
	}

}
