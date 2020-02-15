package com.mvc.kiview.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.kiview.model.dao.NoticeDao;
import com.mvc.kiview.model.vo.FAQVo;
import com.mvc.kiview.model.vo.NoticeVo;

@Service
public class NoticeBizImpl implements NoticeBiz{

	@Autowired
	private NoticeDao n_dao;
	
	
	@Override
	public List<NoticeVo> noticeList() {
		return n_dao.noticeList();
	}

	@Override
	public NoticeVo n_selectOne(int notice_no) {
		return n_dao.n_selectOne(notice_no);
	}

	@Override
	public int notice_insert(NoticeVo n_vo) {
		return n_dao.notice_insert(n_vo);
	}

	@Override
	public int notice_update(NoticeVo n_vo) {
		return n_dao.notice_update(n_vo);
	}

	@Override
	public int notice_delete(int notice_no) {
		return 0;
	}

	@Override
	public List<FAQVo> faqList() {
		return null;
	}

	@Override
	public FAQVo f_selectOne(int faq_no) {
		return null;
	}

	@Override
	public int faq_insert(FAQVo f_vo) {
		return 0;
	}

	@Override
	public int faq_update(FAQVo f_vo) {
		return 0;
	}

	@Override
	public int faq_delete(int faq_no) {
		return 0;
	}

}
