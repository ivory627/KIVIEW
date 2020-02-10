package com.mvc.kiview.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeDaoImpl implements LikeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
		
	@Override
	public String SelectLike(int reviewno, String memberno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String UpdateLike(int reviewno, String memberno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DeleteLike(int reviewno, String memberno) {
		// TODO Auto-generated method stub
		return null;
	}

}
