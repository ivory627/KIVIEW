package com.mvc.kiview.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.Criteria;
import com.mvc.kiview.model.vo.FAQVo;
import com.mvc.kiview.model.vo.NoticeVo;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<NoticeVo> noticeList(Criteria cri) {
		
		List<NoticeVo> list = new ArrayList<NoticeVo>();
		
		try {
			list = sqlSession.selectList("noticeList", cri);
		}catch(Exception e) {
			System.out.println("[error] : notice_list");
		}
		
		return list;
	}
	
	@Override
	public int notice_count() {

		int count = 0;
		
		try {
			count = sqlSession.selectOne(namespace + "listCount");
		}catch(Exception e) {
			System.out.println("[error] : notice count");
			e.printStackTrace();
		}
		
		System.out.println("daoimpl의 list count : " + count);
		
		return count;
		
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

		int res = 0;

		try {
			res = sqlSession.delete(namespace + "noticeDelete", notice_no);
		} catch (Exception e) {
			System.out.println("[error] : notice_delete");
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public void notice_hitupdate(int notice_no) {

		try {
			sqlSession.update(namespace + "hitupdate", notice_no);
		} catch (Exception e) {
			System.out.println("[error] : notice_hit");
			e.printStackTrace();
		}

	}

	@Override
	public void notice_hitminus(int notice_no) {
		try {
			sqlSession.update(namespace + "hitupdateminus", notice_no);
		} catch (Exception e) {
			System.out.println("[error] : notice_hitminus");
			e.printStackTrace();
		}
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
