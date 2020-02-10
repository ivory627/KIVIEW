package com.mvc.kiview.model.biz;

public interface LikeBiz {
	public String SelectLike(int reviewno, String memberno);
	public String UpdateLike(int reviewno, String memberno);
	public String DeleteLike(int reviewno, String memberno); 

}
