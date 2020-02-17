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
	public int reviewInsert() {
		// TODO Auto-generated method stub
		return dao.reviewInsert();
	}

	@Override
	public int reviewUpdate() {
		// TODO Auto-generated method stub
		return dao.reviewUpdate();
	}

	@Override
	public int reviewDelete() {
		// TODO Auto-generated method stub
		return dao.reviewDelete();
	}

	@Override
	public int reviewSearch() {
		// TODO Auto-generated method stub
		return dao.reviewSearch();
	}

}
