package com.mvc.kiview.model.dao;

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
	public List<CafeVo> selectAll() {
		
		return null;
	}

	@Override
	public int cafe_insert(CafeVo vo) {
		System.out.println(vo);
		int res=0;
		
		try {
			res = sqlSession.insert(namespace+"cafe_insert", vo);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("cafeInsert 오류");
		}
		
		return res;
	}
	
	

}
