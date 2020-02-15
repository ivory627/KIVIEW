package com.mvc.kiview.model.dao;

import java.util.List;

import com.mvc.kiview.model.vo.FAQVo;
import com.mvc.kiview.model.vo.NoticeVo;

public interface NoticeDao {

	String namespace = "notice.";

	/* 공지사항 관련 method */

	public List<NoticeVo> noticeList(); // notice게시판 selectList

	public NoticeVo n_selectOne(int notice_no); // notice게시판 selectOne

	public int notice_insert(NoticeVo n_vo); // notice게시판 insert(글쓰기)

	public int notice_update(NoticeVo n_vo); // notice게시판 글 update(수정)

	public int notice_delete(int notice_no); // notice게시판 글 delete(삭제)
//	public void notice_hitupdate(int notice_no); //notice게시글 조회수 update

	public int notice_hitupdate(int notice_no);

	public void notice_hitminus(int notice_no); // notice게시글 조회수 minus

	/* FAQ관련 method */

	public List<FAQVo> faqList(); // FAQ게시판 selectList

	public FAQVo f_selectOne(int faq_no); // FAQ게시판 selectOne

	public int faq_insert(FAQVo f_vo); // FAQ게시판 insert

	public int faq_update(FAQVo f_vo); // FAQ게시판 update

	public int faq_delete(int faq_no); // FAQ게시판 delete

}
