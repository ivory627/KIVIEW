package com.mvc.kiview.model.dao;

import com.mvc.kiview.model.vo.LikeVo;

public interface LikeDao {
	String namespace = "like.";

	public int selectLikeCount(LikeVo vo);
	public int likeInsert(LikeVo vo);
	public int likeDelete(LikeVo vo);

	
	
	
	
	
}
