package com.mvc.kiview.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVo login(MemberVo vo) {
		MemberVo res = null;
		System.out.println(vo.getMember_id()+"/"+vo.getMember_pwd());
		
		try {
			res=sqlSession.selectOne(namespace+"login",vo);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[error] : login");
		}		
		return res;
	}

	@Override
	public MemberVo idSearch(MemberVo vo) {
		MemberVo res = null;
		
		try {
			res=sqlSession.selectOne(namespace+"idSearch",vo);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[error] : idSearch");
		}		
		return res;
	}

	@Override
	public int signup(MemberVo vo) {
		int res = 0;
		
		try {
			res=sqlSession.insert(namespace+"signup",vo);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[error] : signup");
		}		
		return res;
	}

	@Override
	public MemberVo signupIdChk(MemberVo vo) {
		MemberVo res = null;	
		
		try {
			res=sqlSession.selectOne(namespace+"signupIdChk",vo);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[error] : signup");
		}		
		return res;
	}

}



