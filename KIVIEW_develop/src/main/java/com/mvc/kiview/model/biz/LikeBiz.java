package com.mvc.kiview.model.biz;

import com.mvc.kiview.model.vo.LikeVo;

public interface LikeBiz {
	
	public int selectLikeCount(LikeVo vo);
	public int likeInsert(LikeVo vo);
//	public String SelectLike(int reviewno, String memberno);
//	public String UpdateLike(int reviewno, String memberno);
//	public String DeleteLike(int reviewno, String memberno); 

	public int likeDelete(LikeVo vo);

	
	
}
