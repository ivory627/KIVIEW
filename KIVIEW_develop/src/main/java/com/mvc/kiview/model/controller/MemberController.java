package com.mvc.kiview.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.kiview.model.biz.MemberBiz;
import com.mvc.kiview.model.vo.MemberVo;

@Controller // 회원관련
public class MemberController {

   private Logger logger = LoggerFactory.getLogger(MemberController.class);

   @Autowired
   private MemberBiz biz;

   @RequestMapping("/kiviewlogin.do")
   public String kiview_login() {
      logger.info("login");
      return "kiview_login";
   }

   @RequestMapping(value = "/ajaxlogin.do", method = RequestMethod.POST)
   @ResponseBody
   public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberVo vo) {
      logger.info("ajaxLogin");
      MemberVo res = biz.login(vo);
      boolean check = false;

      if (res != null) {
         session.setAttribute("login", res);
         check = true;
      }
      Map<String, Boolean> map = new HashMap<String, Boolean>();
      map.put("check", check);

      return map;
   }
   
   @RequestMapping("/kiviewlogout.do")
   public String kiview_logout(HttpSession session) {
      logger.info("loginout");
      session.invalidate();
      return "index";
   }

   @RequestMapping("/kiviewsignupoption.do")
   public String kiview_signupOption() {
      logger.info("signupOption");
      return "kiview_signup-option";
   }

   @RequestMapping("/kiviewsignup.do")
   public String kiview_signup() {
      logger.info("signup");
      return "kiview_signup";
   }

   /*
    * @RequestMapping(value="/kiviewidsearch.do", method=RequestMethod.POST)
    * 
    * @ResponseBody public String kiview_idSearch(@RequestBody MemberVo vo) {
    * logger.info("idSearch"); MemberVo res = biz.idSearch(vo); return null; 수정 }
    */
   
   

   
   
   

}