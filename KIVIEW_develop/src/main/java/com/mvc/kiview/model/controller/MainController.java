package com.mvc.kiview.model.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.kiview.model.biz.CafeBiz;
import com.mvc.kiview.model.biz.KinderBiz;

import com.mvc.kiview.model.vo.CafeMemberVo;
import com.mvc.kiview.model.vo.CafeVo;

import com.mvc.kiview.model.vo.Criteria;

import com.mvc.kiview.model.vo.KinderVo;
import com.mvc.kiview.model.vo.PageMaker;

@Controller // 인덱스 관련된 컨트롤러
public class MainController {
   
   @Autowired
   private KinderBiz biz;
   
   @Autowired
   private CafeBiz biz_cafe;

   @RequestMapping("/index.do")
   public String index(Model model) {

      List<CafeMemberVo> member = biz_cafe.member_selectAll();
      List<CafeVo> best = biz_cafe.best_cafe();
      
      model.addAttribute("member", member);
      model.addAttribute("best",best);
      

      
      List<KinderVo> kinderlist = biz.bestKinderList();
      List<KinderVo> kinder_res = new ArrayList<KinderVo>();
      List<KinderVo> kinderAll = biz.KinderListAll();
      
      Collections.shuffle(kinderlist);
      
      
      for(int i=0; i<4; i++) {
         kinder_res.add(kinderlist.get(i));
      }
      
      model.addAttribute("bestkinder",kinder_res);
      model.addAttribute("kindercnt",kinderAll.size());
      
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