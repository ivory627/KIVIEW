package com.mvc.kiview.model.dao;




public interface MemberDao {
	String namespace = "member.";
	
	
	public boolean login(String id, String pwd);
}
