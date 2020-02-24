package com.mvc.kiview.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.kiview.model.dao.ReviewDao;
import com.mvc.kiview.model.vo.ReviewVo;

@Service
public class ReviewBizImpl implements ReviewBiz{
	
	@Autowired
	private ReviewDao dao;
	
	@Override
	public List<ReviewVo> reviewList() {
		return dao.reviewList();
	}

	@Override
	public int reviewInsert(ReviewVo vo) {
		return dao.reviewInsert(vo);
	}

	@Override
	public int reviewUpdate(ReviewVo vo) {
		return dao.reviewUpdate(vo);
	}

	@Override
	public int reviewDelete(int review_no) {
		return dao.reviewDelete(review_no);
	}

	@Override
	public int reviewSearch() {
		// TODO Auto-generated method stub
		return dao.reviewSearch();
	}

}
