package com.mvc.kiview.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.KinderVo;
import com.mvc.kiview.model.vo.ReviewVo;

@Repository
public class ReviewDaoImpl implements ReviewDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ReviewVo> reviewList() {
		
		List<ReviewVo> list = new ArrayList<ReviewVo>();
		System.out.println("list" + list);
		
		try {
			list = sqlSession.selectList(namespace + "reviewList");
		} catch(Exception e) {
			System.out.println("error : review list");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int reviewInsert(ReviewVo vo) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(namespace + "reviewInsert", vo);
		} catch(Exception e) {
			System.out.println("error : review insert DaoImpl");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int reviewUpdate(ReviewVo vo) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(namespace + "reviewUpdate", vo);
		} catch(Exception e) {
			System.out.println("error : review update DaoImpl");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int reviewDelete(int review_no) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(namespace + "reviewDelete", review_no);
			System.out.println(review_no);
		} catch(Exception e) {
			System.out.println("error : review delete DaoImpl");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int reviewSearch() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReviewVo reviewSelect(int review_no) {
		ReviewVo res = null;
		
		try {
			res = sqlSession.selectOne(namespace+"reviewselect", review_no);
		} catch (Exception e) {
			System.out.println("error : review select DaoImpl");
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public List<KinderVo> kinderSearch(String keyword) {
		List<KinderVo> res = null;
		
		try {
			res = sqlSession.selectList(namespace+"kinderSearch", keyword);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error : kinder search DaoImpl");
		}
		return res;
	}

	@Override
	public KinderVo kinderSearch2(String kinder_name) {
		KinderVo res = null;
		
		try {
			res = sqlSession.selectOne(namespace+"kinderSearch2", kinder_name);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error : kinder search DaoImpl");
		}
		return res;
	}

}
