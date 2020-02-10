package com.mvc.kiview.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.CafeVo;

@Repository
public class CafeDaoImpl implements CafeDao {
	
	@Autowired
	private SqlSessionTemplate dao;

	@Override
	public List<CafeVo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
