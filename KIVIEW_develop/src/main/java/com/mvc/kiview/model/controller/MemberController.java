package com.mvc.kiview.model.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.mvc.kiview.model.biz.MemberBiz;
import com.mvc.kiview.model.vo.KakaoApi;
import com.mvc.kiview.model.vo.MemberVo;
import com.mvc.kiview.model.vo.NaverLoginBO;

@Controller // 회원관련
public class MemberController {

   private Logger logger = LoggerFactory.getLogger(MemberController.class);

   @Autowired
   private MemberBiz biz;

   @Autowired
   BCryptPasswordEncoder passwordEncoder;
   
   
   //@@ 로그인 @@ /////////////////////////////////////////////////////////////////////////
   //로그인 ajax
   @RequestMapping(value = "/ajaxlogin.do", method = RequestMethod.POST)
   @ResponseBody
   public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberVo vo) {
      logger.info("ajaxLogin");
      MemberVo res = biz.selectOne(vo);
      
      boolean check = false;
      String vopw = vo.getMember_pwd();   //사용자가 입력한 비밀번호
      String respw = res.getMember_pwd();   //db에서 가져온 비밀번호 (암호화된 번호)
      
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
   public String kiview_signupOption(Model model, HttpSession session) throws Exception {
	   logger.info("signupOption");

      /* 구글,네이버,카카오 code 발행 */
      OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
      String googleAuthurl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
      String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
      String kakaoAuthUrl = kakaoApi.getAuthorizationUrl(session);

      /* 생성한 인증 URL을 View로 전달 */
      model.addAttribute("naver_url", naverAuthUrl);
      model.addAttribute("google_url", googleAuthurl);
      model.addAttribute("kakao_url", kakaoAuthUrl);

      System.out.println("model :" + model);

      /* 생성한 인증 URL을 Model에 담아서 전달 */
      return "member/kiview_signup-option";
   }
   
   //kiview 회원가입 페이지
   @RequestMapping("/kiviewsignup.do")
   public String kiview_signup() {
      logger.info("signup");
      return "member/kiview_signup";
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
         return "redirect:login.do";
      }else {
         return "redirect:kiviewsignup.do";
      }

   }
   
   //도로명 api
   @RequestMapping("/kiviewjusopopup")
   public String kiview_jusoPopup() {
      logger.info("addrPopup");
      return "member/addrPopup";
   }
   
   
   //@@ 마이페이지 @@ /////////////////////////////////////////////////////////////////////////
   //마이페이지 - 회원정보
   @RequestMapping("/kiviewmypage.do")
   public String mypage() {
      logger.info("mypage");
      return "member/kiview_mypage"; 
   }
   
   //마이페이지 - 회원활동
   @RequestMapping("/kiviewmyactivity.do")
   public String myactivity() {
      logger.info("myactivity");
      return "member/kiview_myactivity";
   }
   
   //회원정보 수정
   @RequestMapping("/kiviewupdate.do")
   public String memberUpdate (HttpSession session, MemberVo vo) {
      logger.info("memberUpdate");
      vo.setMember_pwd(passwordEncoder.encode(vo.getMember_pwd()));   //수정된 객체 비밀번호 암호화
      int res = biz.updateMember(vo);
      
      //세션에 수정된 로그인정보 담기
      MemberVo res2 = biz.selectOne(vo);
      
      System.out.println("수정된 멤버객체: "+res2);   //삭제
       
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
   
   //소셜 로그인
   /* GoogleLogin */
   @Autowired
   private GoogleConnectionFactory googleConnectionFactory;
   @Autowired
   private OAuth2Parameters googleOAuth2Parameters;

   /* NaverLoginBO */
   private NaverLoginBO naverLoginBO;
   private String apiResult = null;

   /* KakaoLogin */
   private KakaoApi kakaoApi;

   @Autowired
   private void setKakaoApi(KakaoApi kakaoApi) {
      this.kakaoApi = kakaoApi;
   }
   @Autowired
   private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
      this.naverLoginBO = naverLoginBO;
   }

   @RequestMapping("/login.do")
   public String initLogin(Model model, HttpSession session) throws Exception {
	   logger.info("login");
	   /* 구글,네이버,카카오 code 발행 */
	   OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	   String googleAuthurl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
	   String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
	   String kakaoAuthUrl = kakaoApi.getAuthorizationUrl(session);

	   /* 생성한 인증 URL을 View로 전달 */
	   model.addAttribute("naver_url", naverAuthUrl);
	   model.addAttribute("google_url", googleAuthurl);
	   model.addAttribute("kakao_url", kakaoAuthUrl);

	   System.out.println("model :" + model);

	   /* 생성한 인증 URL을 Model에 담아서 전달 */
	   return "member/kiview_login";
   }

   // 네이버 로그인 성공시 callback호출 메소드 **보충 필요
   @RequestMapping(value = "/callback.do")
   public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
         throws IOException {

      System.out.println("네이버 callback");
      OAuth2AccessToken oauthToken;
      oauthToken = naverLoginBO.getAccessToken(session, code, state);
      // 로그인 사용자 정보를 읽어온다.
      apiResult = naverLoginBO.getUserProfile(oauthToken);
      System.out.println(naverLoginBO.getUserProfile(oauthToken).toString());
      model.addAttribute("result", apiResult);
      System.out.println("result" + apiResult);

      return "index";
   }

   //구글 로그인 성공시 callback 호출 **보충 필요
   @RequestMapping("/callback2.do")
   public String callback2(HttpServletRequest request) {

      System.out.println("구글 callback");

      return "index";

   }

   //카카오 로그인 성공시 callback 호출
   @RequestMapping("/callback3.do")
   public String callback3(HttpServletRequest request, @RequestParam("code") String code, HttpSession session) {

      System.out.println("카카오 callback");
      String access_Token = kakaoApi.getAccessToken(code);
      System.out.println("카카오 access token : " + access_Token);

      HashMap<String, Object> userInfo = kakaoApi.getUserInfo(access_Token);
      System.out.println("login Controller : " + userInfo);

      //클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
      if (userInfo.get("email") != null) {
         session.setAttribute("login", userInfo.get("email"));
         session.setAttribute("access_Token", access_Token);
      }

      return "index";

   }
   
   //비밀번호찾기
   @RequestMapping(value = "/kiviewfindPwd.do", method = RequestMethod.POST)
   @ResponseBody
   public Map<String, Boolean> findPwd(@RequestBody MemberVo vo) {
	   logger.info("findPwd");
	   int res = biz.findPwd(vo);

	   boolean check2 = false;

	   if (res>0) {
		   check2 = true;
	   }

	   Map<String, Boolean> map = new HashMap<String, Boolean>();
	   map.put("check2", check2);

	   return map;
   }
   
   
/*
	//비밀번호 찾기 이메일 발송
 	@RequestMapping(value = "/kiviewseneemail.do", method = RequestMethod.POST)
 	logger.info("sendEmail")
	public void send_mail(MemberVo member, String div) throws Exception {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "이메일 입력";
		String hostSMTPpwd = "비밀번호 입력";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "이메일 입력";
		String fromName = "Spring Homepage";
		String subject = "";
		String msg = "";

		if(div.equals("join")) {
			// 회원가입 메일 내용
			subject = "Spring Homepage 회원가입 인증 메일입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += member.getId() + "님 회원가입을 환영합니다.</h3>";
			msg += "<div style='font-size: 130%'>";
			msg += "하단의 인증 버튼 클릭 시 정상적으로 회원가입이 완료됩니다.</div><br/>";
			msg += "<form method='post' action='http://localhost:8081/homepage/member/approval_member.do'>";
			msg += "<input type='hidden' name='email' value='" + member.getEmail() + "'>";
			msg += "<input type='hidden' name='approval_key' value='" + member.getApproval_key() + "'>";
			msg += "<input type='submit' value='인증'></form><br/></div>";
		}else if(div.equals("find_pw")) {
			subject = "Spring Homepage 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += member.getId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += member.getPw() + "</p></div>";
		}
		// 받는 사람 E-Mail 주소
		String mail = member.getEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}
*/
  
   
   
}