package com.mvc.kiview.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.kiview.model.biz.NoticeBiz;

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

		return "kiview_notice_write";
	}

	@RequestMapping("/kiviewintro.do")
	public String kiview_intro() {
		return "kiview_intro";
	}

	@RequestMapping("/kiviewfaq.do")
	public String kiview_faq() {
		return "kiview_FAQ";
	}
	
	@RequestMapping("/se2test.do")
	public String se2_test() {
		return "smarteditor_test";
	}

}
