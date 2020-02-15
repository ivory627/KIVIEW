package com.mvc.kiview.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.FAQVo;
import com.mvc.kiview.model.vo.NoticeVo;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<NoticeVo> noticeList() {

		List<NoticeVo> list = new ArrayList<NoticeVo>();

		try {
			list = sqlSession.selectList(namespace + "noticeList");
		} catch (Exception e) {
			System.out.println("[error] : noticeList");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public NoticeVo n_selectOne(int notice_no) {

		NoticeVo n_vo = null;

		try {
			n_vo = sqlSession.selectOne(namespace + "noticeDetail", notice_no);
		} catch (Exception e) {
			System.out.println("[error] : n_selectOne");
			e.printStackTrace();
		}

		return n_vo;
	}

	@Override
	public int notice_insert(NoticeVo n_vo) {

		int res = 0;

		try {
			res = sqlSession.insert(namespace + "noticeInsert", n_vo);
		} catch (Exception e) {
			System.out.println("[error] : notice_insert");
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int notice_update(NoticeVo n_vo) {

		int res = 0;

		try {
			res = sqlSession.update(namespace + "noticeUpdate", n_vo);
		} catch (Exception e) {
			System.out.println("[error] : notice_update");
			e.printStackTrace();
		}

		return res;
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
