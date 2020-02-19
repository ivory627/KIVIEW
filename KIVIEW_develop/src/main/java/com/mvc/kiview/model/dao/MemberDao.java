package com.mvc.kiview.model.dao;

import com.mvc.kiview.model.vo.MemberVo;

public interface MemberDao {
	
	String namespace = "member.";
	
	public MemberVo login(MemberVo vo);

	public MemberVo idSearch(MemberVo vo);

	public int signup(MemberVo vo);

	public MemberVo signupIdChk(MemberVo vo);
	
}
