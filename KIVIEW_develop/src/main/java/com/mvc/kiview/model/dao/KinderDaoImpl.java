package com.mvc.kiview.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.KinderVo;
import com.mvc.kiview.model.vo.ProvinceVo;

@Repository
public class KinderDaoImpl implements KinderDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<KinderVo> LocalSerach(ProvinceVo vo) {
		List<KinderVo> list = new ArrayList<KinderVo>();
		try {
			list = sqlSession.selectList(namespace+"kinderList",vo);
		}catch(Exception e) {
			System.out.println("error:kinder list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<KinderVo> TypeSearch(HashMap<String, String> map) {
		List<KinderVo> list = new ArrayList<KinderVo>();
		try {
			list = sqlSession.selectList(namespace+"kinderListType",map);
		}catch(Exception e) {
			System.out.println("error:kinder list type");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<KinderVo> NameSearch(String name) {
		List<KinderVo> list = new ArrayList<KinderVo>();
		try {
			list = sqlSession.selectList(namespace+"kinderListName",name);
		}catch(Exception e) {
			System.out.println("error:kinder list name");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public KinderVo Kinderdetail(int kinder_no) {
		KinderVo vo = null;
		try {
			vo = sqlSession.selectOne(namespace+"kinderDetail", kinder_no);
		}catch(Exception e){
			System.out.println("error:kinder detail");
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<ProvinceVo> ProvinceList() {
		List<ProvinceVo> list = new ArrayList<ProvinceVo>();
		try {
			list = sqlSession.selectList(namespace+"provinceList");
		}catch(Exception e) {
			System.out.println("error:province list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProvinceVo> CityList(String province) {
		List<ProvinceVo> list = new ArrayList<ProvinceVo>();
		try {
			list = sqlSession.selectList(namespace+"cityList", province);
		}catch(Exception e) {
			System.out.println("error:city list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProvinceVo> TownList(String city) {
		List<ProvinceVo> list = new ArrayList<ProvinceVo>();
		try {
			list = sqlSession.selectList(namespace+"townList",city);
		}catch(Exception e) {
			System.out.println("error:town list");
			e.printStackTrace();
		}
		return list;
	}
	
	
}
