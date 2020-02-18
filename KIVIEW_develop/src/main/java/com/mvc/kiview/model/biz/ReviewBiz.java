package com.mvc.kiview.model.biz;

import java.util.List;

import com.mvc.kiview.model.vo.LikeVo;
import com.mvc.kiview.model.vo.ReviewVo;

public interface ReviewBiz {
	public List<ReviewVo> reviewList(LikeVo vo); //목록
	public int reviewInsert(); //게시글 쓰기
	public int reviewUpdate(); //게시글 수정
	public int reviewDelete(); //게시글 삭제
	public int reviewSearch(); //검색

}
