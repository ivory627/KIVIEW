package com.mvc.kiview.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.kiview.model.dao.MemberDao;
import com.mvc.kiview.model.vo.MemberVo;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDao dao;
	
	@Override
	public MemberVo login(MemberVo vo) {
		return dao.login(vo);
	}

}
