package com.mvc.kiview.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.CafeMemberVo;
import com.mvc.kiview.model.vo.CafeVo;

@Repository
public class CafeDaoImpl implements CafeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CafeVo> selectAll(int no) {
		
		List<CafeVo> res = new ArrayList();
		
	      try {
	    	 
	    	 
	         res = sqlSession.selectList(namespace+"cafe_selectlist",no);
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	         System.out.println("cafelist list 오류!");
	      }
	         
	      return res;
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
	public CafeVo cafe_selectone(int cafe_no) {
		
		CafeVo vo = new CafeVo();
		
		try {
			
			vo = sqlSession.selectOne(namespace+"cafe_selectone", cafe_no);
			System.out.println(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafeselectone 오류");
		} 
		
		
		
		
		return vo;
	}

	
	
	

}
