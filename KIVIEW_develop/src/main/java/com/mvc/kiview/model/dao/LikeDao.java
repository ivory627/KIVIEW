package com.mvc.kiview.model.dao;


public interface LikeDao {
	String namespace = "like.";
	
	public String SelectLike(int reviewno, String memberno);
	public String UpdateLike(int reviewno, String memberno);
	public String DeleteLike(int reviewno, String memberno); 
}
