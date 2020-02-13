package com.mvc.kiview.model.dao;

import com.mvc.kiview.model.vo.MemberVo;

public interface MemberDao {
	
	String namespace = "member.";
	
	public MemberVo login(MemberVo vo);
	
}
