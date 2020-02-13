package com.mvc.kiview.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.CafeVo;

@Repository
public class CafeDaoImpl implements CafeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CafeVo> selectAll(String id) {
		
		List<CafeVo> listres = new ArrayList<CafeVo>();
	      try {
	         listres = sqlSession.selectList(namespace+"cafe_selectlist",id);
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	         System.out.println("cafelist list 오류!");
	      }
	         
	      return listres;
	}

	@Override
	public int cafe_insert(CafeVo vo) {

		int res=0;
		
		try {
			res = sqlSession.insert(namespace+"cafe_insert", vo);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("cafeInsert 오류");
		}
		
		return res;
	}

	@Override
	public List<CafeVo> cafe_my(String id) {
		System.out.println(id);
		List<CafeVo> list = new ArrayList();
		
		try {
			list = sqlSession.selectList(namespace+"cafe_my", id);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("cafe_my 오류");
		}
		
		return list;
	}
	
	

}
