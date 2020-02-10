package com.mvc.kiview.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.KinderVo;

@Repository
public class KinderDaoImpl implements KinderDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<KinderVo> LocalSerach(String province, String city, String town) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KinderVo> TypeSearch(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KinderVo> NameSearch(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KinderVo> Kinderdetail(String kinderno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
