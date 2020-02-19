package com.mvc.kiview.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	//로그인
	@RequestMapping("/kiviewlogin.do")
	public String kiview_login() {
		logger.info("login");
		return "kiview_login";
	}
	
	//로그인 ajax
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
	
	//로그인 아이디 찾기
	@RequestMapping(value = "/kiviewidsearch.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, MemberVo> kiview_idSearch(@RequestBody MemberVo vo) {
		logger.info("idSearch");
		MemberVo res = biz.idSearch(vo);

		System.out.println(res.getMember_name() + "/" + res.getMember_email() + "/" + res.getMember_id()); // 수정

		Map<String, MemberVo> map = new HashMap<String, MemberVo>();
		map.put("idSearch", res);

		return map;
	}
	
	//로그아웃
	@RequestMapping("/kiviewlogout.do")
	public String kiview_logout(HttpSession session) {
		logger.info("loginout");
		session.invalidate(); 
		return "index";
	}

	//회원가입 종류 선택
	@RequestMapping("/kiviewsignupoption.do")
	public String kiview_signupOption() {
		logger.info("signupOption");
		return "kiview_signup-option";
	}
	
	//회원가입 페이지
	@RequestMapping("/kiviewsignup.do")
	public String kiview_signup() {
		logger.info("signup");
		return "kiview_signup";
	}
	
	//회원가입 중복확인
	@RequestMapping(value = "/kiviewsignupidchk.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> kiview_signupIdChk(@RequestBody MemberVo vo) {
		logger.info("signupIdChk");
		MemberVo res = biz.signupIdChk(vo);
		System.out.println(res.getMember_id());
		boolean signupIdChk = false;

		if (res != null) {
			signupIdChk = true;
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("signupIdChk", signupIdChk);

		return map;
	}

	//회원가입 결과
	@RequestMapping("/kiviewsignupres.do")
	public String kiview_signup(MemberVo vo) {
		logger.info("signupRes");
		System.out.println(vo);
		
		int res = biz.signup(vo);
		
		return "index";

	}

}
