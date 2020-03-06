package com.mvc.kiview.model.biz;

import com.mvc.kiview.model.vo.MemberVo;

public interface MemberBiz {
	
	public MemberVo selectOne(MemberVo vo);

	public MemberVo idSearch(MemberVo vo);

	public int signup(MemberVo vo);

	public MemberVo signupIdChk(MemberVo vo);

	public int updateMember(MemberVo vo);

	public int deleteMember(MemberVo vo);

	public int findPwd(MemberVo vo);

	public MemberVo selectEmail(String snsEmail);

}
