package com.mvc.kiview.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.kiview.model.biz.NoticeBiz;
import com.mvc.kiview.model.vo.NoticeVo;

@Controller // 공지관련
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeBiz n_biz;

	/* 키뷰안내, 공지사항 */
	@RequestMapping("/kiviewnotice.do")
	public String kiview_notice(Model model) {

		logger.info("NOTICE LIST");
		model.addAttribute("noticelist", n_biz.noticeList());

		return "kiview_notice";
	}

	/* 공지사항 selectOne */
	/*
	 * @RequestMapping("/kiviewdetail.do") public String kiview_detail(Model model,
	 * int notice_no) {
	 * 
	 * logger.info("NOTICE DETAIL"); model.addAttribute("noticedetail",
	 * n_biz.n_selectOne(notice_no));
	 * 
	 * return "kiview_notice_detail"; }
	 */

	@RequestMapping("/kiviewdetail.do/{notice_no}")
	public String kiview_detail(HttpServletResponse response, HttpServletRequest request, 
			@PathVariable int notice_no, Model model) {
		
		logger.info("kiviewdetail.do view notice_no = {}", notice_no);
		
		// 저장된 쿠키 불러오기
		Cookie cookies[] = request.getCookies();
		
		Map mapCookie = new HashMap();
		if (request.getCookies() != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie obj = cookies[i];
				mapCookie.put(obj.getName(), obj.getValue());
			}
			System.out.println(mapCookie);
		} 
		
		// 저장된 쿠키중에 read_count 만 불러오기
		String cookie_read_count = (String) mapCookie.get("notice_hit");
		// 저장될 새로운 쿠키값 생성
		String new_cookie_read_count = "|" + notice_no;
		// 저장된 쿠키에 새로운 쿠키값이 존재하는 지 검사
		if (StringUtils.indexOfIgnoreCase(cookie_read_count, new_cookie_read_count) == -1) {
			// 없을 경우 쿠키 생성
			Cookie cookie = new Cookie("notice_hit", cookie_read_count + new_cookie_read_count);
			cookie.setMaxAge(1000); // 초단위
			response.addCookie(cookie); // 조회수 업데이트
			n_biz.notice_hitupdate(notice_no);
		}
		NoticeVo n_vo = n_biz.n_selectOne(notice_no);
		model.addAttribute("noticedetail", n_vo);
		return "kiview_notice_detail";
	}
	


	/*
	 * @RequestMapping(value = "/kiviewdetail.do") public ModelAndView
	 * reviewDetail(HttpServletRequest request, HttpServletResponse response,
	 * HttpSession session, int notice_no) {
	 * 
	 * // 해당 게시판 번호를 받아 리뷰 상세페이지로 넘겨줌 NoticeVo review =
	 * n_biz.n_selectOne(notice_no); ModelAndView view = new ModelAndView();
	 * 
	 * Cookie[] cookies = request.getCookies();
	 * 
	 * // 비교하기 위해 새로운 쿠키 Cookie viewCookie = null;
	 * 
	 * // 쿠키가 있을 경우 if (cookies != null && cookies.length > 0) { for (int i = 0; i <
	 * cookies.length; i++) { // Cookie의 name이 cookie + notice_no와 일치하는 쿠키를
	 * viewCookie에 넣어줌 if (cookies[i].getName().equals("cookie" + notice_no)) {
	 * System.out.println("처음 쿠키가 생성한 뒤 들어옴."); viewCookie = cookies[i]; } } }
	 * 
	 * if (review != null) { System.out.println("System - 해당 상세 리뷰페이지로 넘어감");
	 * 
	 * view.addObject("noticedetail", review);
	 * 
	 * // 만일 viewCookie가 null일 경우 쿠키를 생성해서 조회수 증가 로직을 처리함. if (viewCookie == null) {
	 * System.out.println("cookie 없음");
	 * 
	 * // 쿠키 생성(이름, 값) Cookie newCookie = new Cookie("cookie", "|" + notice_no +
	 * "|");
	 * 
	 * // 쿠키 추가 response.addCookie(newCookie);
	 * 
	 * // 쿠키를 추가 시키고 조회수 증가시킴 int res = n_biz.notice_hitupdate(notice_no);
	 * 
	 * if (res > 0) { System.out.println("조회수 증가"); } else {
	 * System.out.println("조회수 증가 에러"); } } }
	 * view.setViewName("kiview_notice_detail"); return view; }
	 */

	/* admin 계정으로 로그인 - 글쓰기 버튼 클릭시 write 폼으로 */
	@RequestMapping("/kiviewwrite.do")
	public String kiview_write() {

		logger.info("NOTICE WRITE");

		return "kiview_notice_write";
	}

	/* 글 작성 insert redirect 부분 */
	@RequestMapping("/writeRes.do")
	public String kiview_insertRes(NoticeVo n_vo) {

		logger.info("NOTICE WRITE RESULT");

		int res = n_biz.notice_insert(n_vo);

		if (res > 0) {
			return "redirect:kiviewnotice.do";
		} else {
			return "redirect:kiviewwrite.do";
		}

	}

	/* 수정하기 버튼 클릭 시 update폼으로 */
	@RequestMapping("/noticeUpdate.do")
	public String notice_update(Model model, int notice_no) {

		logger.info("NOTICE UPDATE FORM");

		model.addAttribute("noticeupdate", n_biz.n_selectOne(notice_no));

		return "kiview_notice_update";
	}

	/* 수정완료 클릭 시 redirect */
	@RequestMapping("/noticeUpdateRes.do")
	public String notice_updateRes(NoticeVo n_vo) {

		logger.info("NOTICE UPDATE RESULT");

		int res = n_biz.notice_update(n_vo);

		if (res > 0) {
			return "redirect:kiviewdetail.do?notice_no=" + n_vo.getNotice_no();
		} else {
			return "redirect:noticeUpdate.do?notice_no" + n_vo.getNotice_no();
		}

	}

	/* 게시글 삭제 */
	@RequestMapping("/kiviewdel.do")
	public String kiview_delete(int notice_no) {

		logger.info("NOTICE DELETE");

		int res = n_biz.notice_delete(notice_no);

		if (res > 0) {
			return "redirect:kiviewnotice.do";
		} else {
			return "redirect:kiviewdetail.do?notice_no" + notice_no;
		}

	}

	@RequestMapping("/kiviewintro.do")
	public String kiview_intro() {
		return "kiview_intro";
	}

	@RequestMapping("/kiviewfaq.do")
	public String kiview_faq() {
		return "kiview_FAQ";
	}

}
