package com.mvc.kiview.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	//@@ 로그인 @@ /////////////////////////////////////////////////////////////////////////
	//로그인 페이지
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
		MemberVo res = biz.selectOne(vo);
		
		boolean check = false;
		String vopw = vo.getMember_pwd();	//사용자가 입력한 비밀번호
		String respw = res.getMember_pwd();	//db에서 가져온 비밀번호 (암호화된 번호)
		
		if (passwordEncoder.matches(vopw, respw) ) {
			session.setAttribute("login", res);

			//세션 유지 시간 1시간으로 설정
			session.setMaxInactiveInterval(60*60) ;

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

	//@@ 회원가입 @@ /////////////////////////////////////////////////////////////////////////
	//회원가입 종류 선택
	@RequestMapping("/kiviewsignupoption.do")
	public String kiview_signupOption() {
		logger.info("signupOption");
		return "kiview_signup-option";
	}
	
	//kiview 회원가입 페이지
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
		
		vo.setMember_pwd(passwordEncoder.encode(vo.getMember_pwd()));
		System.out.println("암호화된 비밀번호: " + vo.getMember_pwd());
		
		int res = biz.signup(vo);
		 
		if(res > 0) {
			return "redirect:kiviewlogin.do";
		}else {
			return "redirect:kiviewsignup.do";
		}

	}
	
	//도로명 api
	@RequestMapping("/kiviewjusopopup")
	public String kiview_jusoPopup() {
		logger.info("addrPopup");
		return "addrPopup";
	}
	
	
	//@@ 마이페이지 @@ /////////////////////////////////////////////////////////////////////////
	//마이페이지 - 회원정보
	@RequestMapping("/kiviewmypage.do")
	public String mypage() {
		logger.info("mypage");
		return "kiview_mypage"; 
	}
	
	//마이페이지 - 회원활동
	@RequestMapping("/kiviewmyactivity.do")
	public String myactivity() {
		logger.info("myactivity");
		return "kiview_myactivity";
	}
	
	//회원정보 수정
	@RequestMapping("/kiviewupdate.do")
	public String memberUpdate (HttpSession session, MemberVo vo) {
		logger.info("memberUpdate");
		vo.setMember_pwd(passwordEncoder.encode(vo.getMember_pwd()));	//수정된 객체 비밀번호 암호화
		int res = biz.updateMember(vo);
		
		//세션에 수정된 로그인정보 담기
		MemberVo res2 = biz.selectOne(vo);
		
		System.out.println("수정된 멤버객체: "+res2);	//삭제
		 
		//session.invalidate();
		session.setAttribute("login", res2);

		//세션 유지 시간 1시간으로 설정
		session.setMaxInactiveInterval(60*60) ;
		
		return "redirect:kiviewmypage.do";
	}


	//회원 탈퇴
	@RequestMapping(value="/kiviewdelete.do", method=RequestMethod.POST)
	public String deleteMember(HttpSession session) {
		logger.info("deleteMember");
		MemberVo vo = (MemberVo) session.getAttribute("login");
		int res = biz.deleteMember(vo);
		session.invalidate();
		return "redirect:index.do";
	}
	   

	
	
	
	
}
