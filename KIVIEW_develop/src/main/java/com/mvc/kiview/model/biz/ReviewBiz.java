package com.mvc.kiview.model.biz;

import java.util.List;

import com.mvc.kiview.model.vo.ReviewVo;

public interface ReviewBiz {
	public List<ReviewVo> reviewList(); //목록
	public int reviewInsert(ReviewVo vo); //게시글 쓰기
	public int reviewUpdate(ReviewVo vo); //게시글 수정
	public int reviewDelete(int review_no); //게시글 삭제
	public int reviewSearch(); //검색

}