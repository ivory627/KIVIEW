package com.mvc.kiview.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.kiview.model.biz.NoticeBiz;
import com.mvc.kiview.model.vo.NoticeVo;

@Controller // 공지관련
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeBiz n_biz;

	@RequestMapping("/kiviewnotice.do")
	public String kiview_notice(Model model) {

		logger.info("NOTICE LIST");
		model.addAttribute("noticelist", n_biz.noticeList());

		return "kiview_notice";
	}

	@RequestMapping("/kiviewdetail.do")
	public String kiview_detail(Model model, int notice_no) {

		logger.info("NOTICE DETAIL");
		model.addAttribute("noticedetail", n_biz.n_selectOne(notice_no));

		return "kiview_notice_detail";
	}

	@RequestMapping("/kiviewwrite.do")
	public String kiview_write() {

		logger.info("NOTICE WRITE");

		return "kiview_notice_write";
	}

	@RequestMapping("/writeRes.do")
	public String kiview_insertRes(NoticeVo n_vo) {

		logger.info("NOTICE WRITE RESULT");

		int res = n_biz.notice_insert(n_vo);

		if (res > 0) {
			return "redirect:kiviewnotice.do";
		} else {
			System.out.println("insert 실패야");
			return "redirect:kiviewwrite.do";
		}

	}

	@RequestMapping("/noticeUpdate.do")
	public String notice_update(Model model, int notice_no) {

		logger.info("NOTICE UPDATE FORM");

		model.addAttribute("noticeupdate", n_biz.n_selectOne(notice_no));

		return "kiview_notice_update";
	}

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

	@RequestMapping("/kiviewintro.do")
	public String kiview_intro() {
		return "kiview_intro";
	}

	@RequestMapping("/kiviewfaq.do")
	public String kiview_faq() {
		return "kiview_FAQ";
	}

}
